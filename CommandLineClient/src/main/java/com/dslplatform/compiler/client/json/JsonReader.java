package com.dslplatform.compiler.client.json;

import java.io.IOException;
import java.nio.charset.Charset;

final class JsonReader {

	private static final boolean[] WHITESPACE = new boolean[256];

	static {
		WHITESPACE[9 + 128] = true;
		WHITESPACE[10 + 128] = true;
		WHITESPACE[11 + 128] = true;
		WHITESPACE[12 + 128] = true;
		WHITESPACE[13 + 128] = true;
		WHITESPACE[32 + 128] = true;
		WHITESPACE[-96 + 128] = true;
		WHITESPACE[-31 + 128] = true;
		WHITESPACE[-30 + 128] = true;
		WHITESPACE[-29 + 128] = true;
	}

	private int tokenStart;
	protected int currentIndex = 0;
	private long currentPosition = 0;
	private byte last = ' ';

	protected int length;
	private final char[] tmp;

	protected final byte[] buffer;

	protected JsonReader(final char[] tmp, final byte[] buffer, final int length) {
		this.tmp = tmp;
		this.buffer = buffer;
		this.length = length;
	}

	public JsonReader(final byte[] buffer, final int length) throws IOException {
		this(buffer, length, new char[64]);
	}

	public JsonReader(final byte[] buffer, final int length, final char[] tmp) throws IOException {
		this(tmp, buffer, length);
		if (tmp == null) {
			throw new NullPointerException("tmp buffer provided as null.");
		}
		if (length > buffer.length) {
			throw new IOException("length can't be longer than buffer.length");
		} else if (length < buffer.length) {
			buffer[length] = '\0';
		}
	}

	public int length() {
		return length;
	}

	void reset(int newLength) {
		currentPosition += currentIndex;
		currentIndex = 0;
		this.length = newLength;
	}

	private final static Charset UTF_8 = Charset.forName("UTF-8");

	@Override
	public String toString() {
		return new String(buffer, 0, length, UTF_8);
	}

	public byte read() throws IOException {
		if (currentIndex >= length) {
			throw new IOException("Unexpected end of JSON input");
		}
		return last = buffer[currentIndex++];
	}

	boolean isEndOfStream() throws IOException {
		return length == currentIndex;
	}

	public final byte last() {
		return last;
	}

	public final int getTokenStart() {
		return tokenStart;
	}

	public final int getCurrentIndex() {
		return currentIndex;
	}

	public final char[] readNumber() {
		tokenStart = currentIndex - 1;
		tmp[0] = (char) last;
		int i = 1;
		int ci = currentIndex;
		byte bb = last;
		while (i < tmp.length && ci < length) {
			bb = buffer[ci++];
			if (bb == ',' || bb == '}' || bb == ']') break;
			tmp[i++] = (char) bb;
		}
		currentIndex += i - 1;
		last = bb;
		return tmp;
	}

	public final String readSimpleString() throws IOException {
		if (last != '"')
			throw new IOException("Expecting '\"' at position " + positionInStream() + ". Found " + (char) last);
		int i = 0;
		int ci = currentIndex;
		try {
			while (i < tmp.length) {
				final byte bb = buffer[ci++];
				if (bb == '"') break;
				tmp[i++] = (char) bb;
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
			throw new IOException("JSON string was not closed with a double quote at: " + currentIndex);
		}
		if (ci > length) {
			throw new IOException("JSON string was not closed with a double quote at: " + currentIndex);
		}
		currentIndex = ci;
		return new String(tmp, 0, i);
	}

	public final char[] readSimpleQuote() throws IOException {
		if (last != '"') {
			throw new IOException("Expecting '\"' at position " + positionInStream() + ". Found " + (char) last);
		}
		int ci = tokenStart = currentIndex;
		try {
			for (int i = 0; i < tmp.length; i++) {
				final byte bb = buffer[ci++];
				if (bb == '"') break;
				tmp[i] = (char) bb;
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
			throw new IOException("JSON string was not closed with a double quote at: " + currentIndex);
		}
		if (ci > length) {
			throw new IOException("JSON string was not closed with a double quote at: " + currentIndex);
		}
		currentIndex = ci;
		return tmp;
	}

	public final String readString() throws IOException {
		final int startIndex = currentIndex;
		if (last != '"') {
			//TODO: count special chars in separate counter
			throw new IOException("JSON string must start with a double quote at: " + positionInStream());
		}

		byte bb = 0;
		int ci = currentIndex;
		try {
			for (int i = 0; i < tmp.length; i++) {
				bb = buffer[ci++];
				if (bb == '"') {
					currentIndex = ci;
					return new String(tmp, 0, i);
				}
				// If we encounter a backslash, which is a beginning of an escape sequence
				// or a high bit was set - indicating an UTF-8 encoded multibyte character,
				// there is no chance that we can decode the string without instantiating
				// a temporary buffer, so quit this loop
				if ((bb ^ '\\') < 1) break;
				tmp[i] = (char) bb;
			}
		} catch (ArrayIndexOutOfBoundsException ignore) {
			throw new IOException("JSON string was not closed with a double quote at: " + positionInStream());
		}
		if (ci >= length) {
			throw new IOException("JSON string was not closed with a double quote at: " + ci);
		}

		// If the buffer contains an ASCII string (no high bit set) without any escape codes "\n", "\t", etc...,
		// there is no need to instantiate any temporary buffers, we just decode the original buffer directly
		// via ISO-8859-1 encoding since it is the fastest encoding which is guaranteed to retain all ASCII characters
		while (ci < buffer.length) {
			// If we encounter a backslash, which is a beginning of an escape sequence
			// or a high bit was set - indicating an UTF-8 encoded multibyte character,
			// there is no chance that we can decode the string without instantiating
			// a temporary buffer, so quit this loop
			if ((bb ^ '\\') < 1) break;
			bb = buffer[ci++];
			if (bb == '"') {
				currentIndex = ci;
				return new String(buffer, startIndex, currentIndex - startIndex - 1, "ISO-8859-1");
			}
		}
		currentIndex = ci;

		return readLargeString(startIndex);
	}

	protected String readLargeString(final int startIndex) throws IOException {

		if (currentIndex >= length) {
			throw new IOException("JSON string was not closed with a double quote at: " + currentIndex);
		}

		int soFar = --currentIndex - startIndex;
		char[] chars = new char[soFar + 256];

		for (int i = soFar - 1; i >= 0; i--) {
			chars[i] = (char) buffer[startIndex + i];
		}

		while (currentIndex < length) {
			int bc = buffer[currentIndex++];
			if (bc == '"') {
				return new String(chars, 0, soFar);
			}

			// if we're running out of space, double the buffer capacity
			if (soFar >= chars.length - 3) {
				final char[] newChars = new char[chars.length << 1];
				System.arraycopy(chars, 0, newChars, 0, soFar);
				chars = newChars;
			}

			if (bc == '\\') {
				bc = buffer[currentIndex++];

				switch (bc) {
					case 'b':
						bc = '\b';
						break;
					case 't':
						bc = '\t';
						break;
					case 'n':
						bc = '\n';
						break;
					case 'f':
						bc = '\f';
						break;
					case 'r':
						bc = '\r';
						break;
					case '"':
					case '/':
					case '\\':
						break;
					case 'u':
						bc = (hexToInt(buffer[currentIndex++]) << 12) +
								(hexToInt(buffer[currentIndex++]) << 8) +
								(hexToInt(buffer[currentIndex++]) << 4) +
								hexToInt(buffer[currentIndex++]);
						break;

					default:
						throw new IOException("Could not parse String, got invalid escape combination '\\" + bc + "'");
				}
			} else if ((bc & 0x80) != 0) {
				final int u2 = buffer[currentIndex++];
				if ((bc & 0xE0) == 0xC0) {
					bc = ((bc & 0x1F) << 6) + (u2 & 0x3F);
				} else {
					final int u3 = buffer[currentIndex++];
					if ((bc & 0xF0) == 0xE0) {
						bc = ((bc & 0x0F) << 12) + ((u2 & 0x3F) << 6) + (u3 & 0x3F);
					} else {
						final int u4 = buffer[currentIndex++];
						if ((bc & 0xF8) == 0xF0) {
							bc = ((bc & 0x07) << 18) + ((u2 & 0x3F) << 12) + ((u3 & 0x3F) << 6) + (u4 & 0x3F);
						} else {
							// there are legal 5 & 6 byte combinations, but none are _valid_
							throw new IOException();
						}

						if (bc >= 0x10000) {
							// check if valid unicode
							if (bc >= 0x110000) throw new IOException();

							// split surrogates
							final int sup = bc - 0x10000;
							chars[soFar++] = (char) ((sup >>> 10) + 0xd800);
							chars[soFar++] = (char) ((sup & 0x3ff) + 0xdc00);
						}
					}
				}
			}

			chars[soFar++] = (char) bc;
		}
		throw new IOException("JSON string was not closed with a double quote!");
	}

	protected static int hexToInt(final byte value) throws IOException {
		if (value >= '0' && value <= '9') return value - 0x30;
		if (value >= 'A' && value <= 'F') return value - 0x37;
		if (value >= 'a' && value <= 'f') return value - 0x57;
		throw new IOException("Could not parse unicode escape, expected a hexadecimal digit, got '" + value + "'");
	}

	private boolean wasWhiteSpace() {
		switch (last) {
			case 9:
			case 10:
			case 11:
			case 12:
			case 13:
			case 32:
			case -96:
				return true;
			case -31:
				if (currentIndex + 1 < length && buffer[currentIndex] == -102 && buffer[currentIndex + 1] == -128) {
					currentIndex += 2;
					last = ' ';
					return true;
				}
				return false;
			case -30:
				if (currentIndex + 1 < length) {
					final byte b1 = buffer[currentIndex];
					final byte b2 = buffer[currentIndex + 1];
					if (b1 == -127 && b2 == -97) {
						currentIndex += 2;
						last = ' ';
						return true;
					}
					if (b1 != -128) return false;
					switch (b2) {
						case -128:
						case -127:
						case -126:
						case -125:
						case -124:
						case -123:
						case -122:
						case -121:
						case -120:
						case -119:
						case -118:
						case -88:
						case -87:
						case -81:
							currentIndex += 2;
							last = ' ';
							return true;
						default:
							return false;
					}
				} else {
					return false;
				}
			case -29:
				if (currentIndex + 1 < length && buffer[currentIndex] == -128 && buffer[currentIndex + 1] == -128) {
					currentIndex += 2;
					last = ' ';
					return true;
				}
				return false;
			default:
				return false;
		}
	}

	public final byte getNextToken() throws IOException {
		read();
		if (WHITESPACE[last + 128]) {
			while (wasWhiteSpace()) {
				read();
			}
		}
		return last;
	}

	public final long positionInStream() {
		return currentPosition + currentIndex;
	}

	public final int fillName() throws IOException {
		if (last != '"') {
			throw new IOException("Expecting '\"' at position " + positionInStream() + ". Found " + (char) last);
		}
		tokenStart = currentIndex;
		int ci = currentIndex;
		long hash = 0x811c9dc5;
		while (ci < buffer.length) {
			final byte b = buffer[ci++];
			if (b == '"') break;
			hash ^= b;
			hash *= 0x1000193;
		}
		currentIndex = ci;
		if (read() != ':') {
			if (!wasWhiteSpace() || getNextToken() != ':') {
				throw new IOException("Expecting ':' at position " + positionInStream() + ". Found " + (char) last);
			}
		}
		return (int) hash;
	}

	public final int calcHash() throws IOException {
		if (last != '"') {
			throw new IOException("Expecting '\"' at position " + positionInStream() + ". Found " + (char) last);
		}
		tokenStart = currentIndex;
		int ci = currentIndex;
		long hash = 0x811c9dc5;
		while (ci < buffer.length) {
			final byte b = buffer[ci++];
			if (b == '"') break;
			hash ^= b;
			hash *= 0x1000193;
		}
		currentIndex = ci;
		return (int) hash;
	}

	public final boolean wasLastName(final String name) {
		if (name.length() != currentIndex - tokenStart) {
			return false;
		}
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) != buffer[tokenStart + i]) {
				return false;
			}
		}
		return true;
	}

	public final String getLastName() throws IOException {
		return new String(buffer, tokenStart, currentIndex - tokenStart - 1, "ISO-8859-1");
	}

	private byte skipString() throws IOException {
		byte c = read();
		byte prev = c;
		while (c != '"' || prev == '\\') {
			prev = c;
			c = read();
		}
		return getNextToken();
	}

	public final byte skip() throws IOException {
		if (last == '"') return skipString();
		else if (last == '{') {
			byte nextToken = getNextToken();
			if (nextToken == '}') return getNextToken();
			if (nextToken == '"') nextToken = skipString();
			else
				throw new IOException("Expecting '\"' at position " + positionInStream() + ". Found " + (char) nextToken);
			if (nextToken != ':')
				throw new IOException("Expecting ':' at position " + positionInStream() + ". Found " + (char) nextToken);
			getNextToken();
			nextToken = skip();
			while (nextToken == ',') {
				nextToken = getNextToken();
				if (nextToken == '"') nextToken = skipString();
				else
					throw new IOException("Expecting '\"' at position " + positionInStream() + ". Found " + (char) nextToken);
				if (nextToken != ':')
					throw new IOException("Expecting ':' at position " + positionInStream() + ". Found " + (char) nextToken);
				getNextToken();
				nextToken = skip();
			}
			if (nextToken != '}')
				throw new IOException("Expecting '}' at position " + positionInStream() + ". Found " + (char) nextToken);
			return getNextToken();
		} else if (last == '[') {
			getNextToken();
			byte nextToken = skip();
			while (nextToken == ',') {
				getNextToken();
				nextToken = skip();
			}
			if (nextToken != ']')
				throw new IOException("Expecting ']' at position " + positionInStream() + ". Found " + (char) nextToken);
			return getNextToken();
		} else {
			while (last != ',' && last != '}' && last != ']')
				read();
			return last;
		}
	}

	public String readNext() throws IOException {
		final int start = currentIndex - 1;
		skip();
		return new String(buffer, start, currentIndex - start - 1, "UTF-8");
	}

	public final boolean wasNull() throws IOException {
		if (last == 'n') {
			if (currentIndex + 2 < length && buffer[currentIndex] == 'u'
					&& buffer[currentIndex + 1] == 'l' && buffer[currentIndex + 2] == 'l') {
				currentIndex += 3;
				last = 'l';
				return true;
			}
			throw new IOException("Invalid null value found at: " + currentIndex);
		}
		return false;
	}

	public final boolean wasTrue() throws IOException {
		if (last == 't') {
			if (currentIndex + 2 < length && buffer[currentIndex] == 'r'
					&& buffer[currentIndex + 1] == 'u' && buffer[currentIndex + 2] == 'e') {
				currentIndex += 3;
				last = 'e';
				return true;
			}
			throw new IOException("Invalid boolean value found at: " + currentIndex);
		}
		return false;
	}

	public final boolean wasFalse() throws IOException {
		if (last == 'f') {
			if (currentIndex + 3 < length && buffer[currentIndex] == 'a'
					&& buffer[currentIndex + 1] == 'l' && buffer[currentIndex + 2] == 's'
					&& buffer[currentIndex + 3] == 'e') {
				currentIndex += 4;
				last = 'e';
				return true;
			}
			throw new IOException("Invalid boolean value found at: " + currentIndex);
		}
		return false;
	}
}
