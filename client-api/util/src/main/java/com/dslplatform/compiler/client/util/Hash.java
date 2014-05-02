package com.dslplatform.compiler.client.util;

import java.io.Serializable;
import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

public class Hash implements Serializable {
    public final byte[] hash;

// ----------------------------------------------------------------------------

    public final int hashCode;

// ----------------------------------------------------------------------------

    public Hash(
            final byte[] body) {
        hash = DigestUtils.sha256(body);
        hashCode = Arrays.hashCode(hash);
    }

    private Hash(
            final byte[] hash,
            final int hashCode) {
        this.hash = hash;
        this.hashCode = hashCode;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(final Object that) {
        if (!(that instanceof Hash) || that == null) return false;

        final Hash thatHash = (Hash) that;
        return hashCode ==  thatHash.hashCode && Arrays.equals(hash, thatHash.hash);
    }

// ----------------------------------------------------------------------------

    public Hash toHash() {
        return new Hash(hash, hashCode);
    }

    public static class Body extends Hash {
        public final byte[] body;

        public Body(
                final byte[] body) {
            super(body);
            this.body = body;
        }

        private static final long serialVersionUID = 0x0L;
    }

// ----------------------------------------------------------------------------

    @Override
    public String toString() {
        return String.format("%08X", hashCode);
    }

    private static final long serialVersionUID = 0x0L;
}
