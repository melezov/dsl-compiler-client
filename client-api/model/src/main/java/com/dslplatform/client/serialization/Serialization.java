package com.dslplatform.client.serialization;

import java.io.IOException;
import java.io.OutputStream;

public interface Serialization<TFormat> {
    public <T> void serialize(final OutputStream outputStream, final T value) throws IOException;
    public <T> TFormat serialize(final T value);
}
