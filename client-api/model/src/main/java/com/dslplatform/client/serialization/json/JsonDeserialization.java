package com.dslplatform.client.serialization.json;

import io.jvm.json.JsonDeserializer;
import io.jvm.json.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.dslplatform.client.serialization.Deserialization;
import com.dslplatform.patterns.ServiceLocator;

public class JsonDeserialization implements Deserialization<String> {
    private final ServiceLocator serviceLocator;
    private final Map<Class<?>, Class<? extends JsonDeserializer<?>>> components;
    private final Map<Class<?>, JsonDeserializer<?>> deserializers;

    public JsonDeserialization(final ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        components = new LinkedHashMap<>();
        deserializers = new LinkedHashMap<>();
    }

    @SuppressWarnings({ "rawtypes" })
    private Class<?> getTarget(final Class<? extends JsonDeserializer> deserializerClass) {
        final ParameterizedType paramType = (ParameterizedType) (deserializerClass.getGenericInterfaces()[0]);
        final Type type = paramType.getActualTypeArguments()[0];
        if (!(type instanceof Class)) {
            throw new RuntimeException("Type <" + type + "> is not a valid deserialization target!");
        }
        return (Class<?>) type;
    }

    protected JsonDeserialization register(final JsonDeserializer<?> deserializer) {
        deserializers.put(getTarget(deserializer.getClass()), deserializer);
        return this;
    }

    protected JsonDeserialization register(final Class<? extends JsonDeserializer<?>> deserializerClass) {
        final Class<?> clazz = getTarget(deserializerClass);
        deserializers.remove(clazz);
        components.put(clazz, deserializerClass);
        return this;
    }

    private JsonDeserializer<?> resolveDeserializerParam(final Type paramType) {
        if (!(paramType instanceof ParameterizedType)) return null;

        final ParameterizedType pType = (ParameterizedType) paramType;
        final Type rawType = pType.getRawType();
        if (!(rawType instanceof Class)) return null;

        if (!JsonDeserializer.class.isAssignableFrom((Class<?>) rawType)) return null;

        final Type targetType = pType.getActualTypeArguments()[0];
        if (!(targetType instanceof Class)) return null;

        final Class<?> targetClass = (Class<?>) targetType;
        return resolve(targetClass);
    }

    private Object resolveExternalParam(final Type paramType) {
        if (!(paramType instanceof Class)) return null;

        try {
            return serviceLocator.resolve((Class<?>) paramType);
        }
        catch (final RuntimeException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private <T> JsonDeserializer<T> resolve(final Class<T> clazz) {
        final JsonDeserializer<T> deserializer = (JsonDeserializer<T>) deserializers.get(clazz);
        if (deserializer != null) return deserializer;

        final Class<JsonDeserializer<T>> deserializerClass = (Class<JsonDeserializer<T>>) components.get(clazz);
        if (deserializerClass == null) return null;

        for (final Constructor<JsonDeserializer<T>> constructor : (Constructor<JsonDeserializer<T>>[]) deserializerClass.getConstructors()) {
            final ArrayList<Object> args = new ArrayList<Object>();
            boolean success = true;
            for (final Type paramType : constructor.getGenericParameterTypes()) {
                final JsonDeserializer<?> deserializerParam = resolveDeserializerParam(paramType);
                if (deserializerParam != null) {
                    args.add(deserializerParam);
                    continue;
                }

                final Object externalParam = resolveExternalParam(paramType);
                if (externalParam != null) {
                    args.add(externalParam);
                    continue;
                }

                success = false;
                break;
            }

            if (success) {
                try {
                    final JsonDeserializer<T> newDeserializer = constructor.newInstance(args.toArray());
                    deserializers.put(clazz, newDeserializer);
                    return newDeserializer;
                } catch (final Exception e) {
                    continue;
                }
            }
        }

        return null;
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
        final JsonDeserializer<T> deserializer = resolve(clazz);

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
