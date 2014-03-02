package com.dslplatform.client.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public interface Deserialization<TFormat> {
    public <T> T deserialize(final InputStream inputStream, final Class<T> clazz) throws IOException;
    public <T> T deserialize(final TFormat value, final Class<T> clazz);

    public <T, C extends Collection<T>> C deserialize(final InputStream inputStream, final Class<T> clazz, final C builder) throws IOException;
    public <T, C extends Collection<T>> C deserialize(final TFormat value, final Class<T> clazz, final C builder);
}
