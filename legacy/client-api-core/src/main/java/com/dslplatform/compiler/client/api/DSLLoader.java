package com.dslplatform.compiler.client.api;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.regex.Pattern;

import com.dslplatform.compiler.client.api.commons.FileLoader;
import com.dslplatform.compiler.client.api.params.DSL;
import com.dslplatform.compiler.client.api.params.Environment;
import com.dslplatform.compiler.client.io.Logger;

public class DSLLoader {
    private final Logger logger;
    private final Charset encoding;

    public DSLLoader(
            final Logger logger) {
        this(logger, new Environment());
    }

    public DSLLoader(
            final Logger logger,
            final String encoding) {
        this(logger, Charset.forName(encoding));
    }

    public DSLLoader(
            final Logger logger,
            final Charset encoding) {
        this.logger = logger;
        this.encoding = encoding;
        fileLoader = new FileLoader(logger);
    }

    public DSLLoader(
            final Logger logger,
            final Environment environment) {
        this(logger, environment.encoding);
    }

    // -------------------------------------------------------------------------

    private final FileLoader fileLoader;

    private static final String DSL_PATTERN = ".*\\.dsl$";

    public DSLLoader addPath(final String path) throws IOException {
        return addPath(path, DSL_PATTERN);
    }

    public DSLLoader addPath(final String path, final String pattern)
            throws IOException {
        return addPath(path, Pattern.compile(pattern));
    }

    public DSLLoader addPath(final String path, final Pattern pattern)
            throws IOException {
        fileLoader.addPath(path, path, pattern);
        return this;
    }

    // -------------------------------------------------------------------------

    public DSL getDSL() throws IOException {
        final SortedMap<String, byte[]> binaryFiles = fileLoader.getBodies();

        final Map<String, String> dslFiles = new LinkedHashMap<String, String>();

        for (final Map.Entry<String, byte[]> entry : binaryFiles.entrySet()) {
            final String file = entry.getKey();
            logger.trace("Dsl file path: " + file);
            final byte[] body = entry.getValue();

            try {
                final String text = new String(body, encoding);
                if (!Arrays.equals(text.getBytes(encoding), body)) {
                    throw new Exception("Encode/decode via " + encoding
                            + " - check failed");
                }
                dslFiles.put(file, text);
            } catch (final Exception e) {
                throw new IOException("File \"" + file
                        + "\" could not be decoded via " + encoding
                        + " encoding", e);
            }
        }

        return new DSL(dslFiles);
    }
}