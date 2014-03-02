package com.dslplatform.client.serialization.json;

import io.jvm.json.JsonDeserializer;
import io.jvm.json.JsonReader;
import io.jvm.json.deserializers.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.dslplatform.client.serialization.Deserialization;

public class JsonDeserialization implements Deserialization<String> {
    private final Map<Class<Object>, JsonDeserializer<Object>> deserializers;

    public JsonDeserialization() {
        deserializers = new LinkedHashMap<>();

        register(new ByteJsonDeserializer())
        .register(new ByteArrayJsonDeserializer())
        .register(new ShortJsonDeserializer())
        .register(new ShortArrayJsonDeserializer())
        .register(new IntegerJsonDeserializer())
        .register(new IntArrayJsonDeserializer())
        .register(new LongJsonDeserializer())
        .register(new LongArrayJsonDeserializer())
        .register(new FloatJsonDeserializer())
        .register(new FloatArrayJsonDeserializer())
        .register(new DoubleJsonDeserializer())
        .register(new DoubleArrayJsonDeserializer())
        .register(new BooleanJsonDeserializer())
        .register(new BooleanArrayJsonDeserializer())
        .register(new CharacterJsonDeserializer())
        .register(new CharArrayJsonDeserializer())

        .register(new BigDecimalJsonDeserializer())
        .register(new BigIntegerJsonDeserializer())
        .register(new DateTimeJsonDeserializer())
        .register(new LocalDateJsonDeserializer())
        .register(new StringJsonDeserializer())
        .register(new UUIDJsonDeserializer());
    }

    @SuppressWarnings("unchecked")
    public JsonDeserialization register(final JsonDeserializer<?> deserializer) {
        final ParameterizedType paramType = (ParameterizedType) (deserializer.getClass().getGenericInterfaces()[0]);
        final Class<Object> clazz = (Class<Object>) paramType.getActualTypeArguments()[0];
        deserializers.put(clazz, (JsonDeserializer<Object>) deserializer);
        return this;
    }

    @Override
    public <T> T deserialize(final InputStream inputStream, final Class<T> clazz) throws IOException {
        final Reader reader = new InputStreamReader(inputStream, "UTF-8");
        return deserialize(new JsonReader(reader), clazz);
    }

    @Override
    public <T> T deserialize(final String value, final Class<T> clazz) {
        final Reader reader = new StringReader(value);
        try {
            return deserialize(new JsonReader(reader), clazz);
        } catch (final IOException e) {
            throw new RuntimeException("Could not deserialize object of class: " + clazz, e);
        }
    }

    @Override
    public <T, C extends Collection<T>> C deserialize(final InputStream inputStream, final Class<T> clazz, final C builder) throws IOException {
        final Reader reader = new InputStreamReader(inputStream, "UTF-8");
        return deserialize(new JsonReader(reader), clazz, builder);
    }

    @Override
    public <T, C extends Collection<T>> C deserialize(final String value, final Class<T> clazz, final C builder) {
        final Reader reader = new StringReader(value);
        try {
            return deserialize(new JsonReader(reader), clazz, builder);
        } catch (final IOException e) {
            throw new RuntimeException("Could not deserialize collection of objects of class: " + clazz, e);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T deserialize(final JsonReader jsonReader, final Class<T> clazz) throws IOException {
        final JsonDeserializer<T> deserializer = (JsonDeserializer<T>) deserializers.get(clazz);

      if (deserializer != null) {
          return deserializer.fromJson(jsonReader);
      }

      if (clazz.isArray()) {
          final Class<T> elementClass = (Class<T>) clazz.getComponentType();
          final Collection<T> elements = deserialize(jsonReader, elementClass, new ArrayList<T>());
          if (elements == null) return null;

          final T[] elementsArray = (T[]) Array.newInstance(elementClass, elements.size());
          return (T) elements.toArray(elementsArray);
      }

      throw new RuntimeException("Could not locate deserializer for object of class: " + clazz.getName());
    }

    private <T, C extends Collection<T>> C deserialize(final JsonReader jsonReader, final Class<T> clazz, final C builder) throws IOException {
        if (jsonReader.read() == '[') {
            if (jsonReader.next() != ']') {
                final T first = deserialize(jsonReader, clazz);
                builder.add(first);

                while (jsonReader.read() != ']') {
                    jsonReader.assertLast(',');
                    final T current = deserialize(jsonReader, clazz);
                    builder.add(current);
                }
            }

            jsonReader.invalidate();
            return builder;
        }

        return jsonReader.readNull();
    }
}
