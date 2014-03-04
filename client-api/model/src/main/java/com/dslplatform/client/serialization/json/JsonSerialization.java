package com.dslplatform.client.serialization.json;

import io.jvm.json.JsonSerializer;
import io.jvm.json.JsonWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.dslplatform.client.serialization.Serialization;
import com.dslplatform.patterns.ServiceLocator;

public class JsonSerialization implements Serialization<String> {
    private final ServiceLocator serviceLocator;
    private final Map<Class<?>, Class<? extends JsonSerializer<?>>> components;
    private final Map<Class<?>, JsonSerializer<?>> serializers;

    public JsonSerialization(final ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        components = new LinkedHashMap<>();
        serializers = new LinkedHashMap<>();
    }

    @SuppressWarnings({ "rawtypes" })
    private Class<?> getTarget(final Class<? extends JsonSerializer> serializerClass) {
        final ParameterizedType paramType = (ParameterizedType) (serializerClass.getGenericInterfaces()[0]);
        final Type type = paramType.getActualTypeArguments()[0];
        if (!(type instanceof Class)) {
            throw new RuntimeException("Type <" + type + "> is not a valid serialization target!");
        }
        return (Class<?>) type;
    }

    protected JsonSerialization register(final JsonSerializer<?> serializer) {
        serializers.put(getTarget(serializer.getClass()), serializer);
        return this;
    }

    protected JsonSerialization register(final Class<? extends JsonSerializer<?>> serializerClass) {
        final Class<?> clazz = getTarget(serializerClass);
        serializers.remove(clazz);
        components.put(clazz, serializerClass);
        return this;
    }

    private JsonSerializer<?> resolveSerializerParam(final Type paramType) {
        if (!(paramType instanceof ParameterizedType)) return null;

        final ParameterizedType pType = (ParameterizedType) paramType;
        final Type rawType = pType.getRawType();
        if (!(rawType instanceof Class)) return null;

        if (!JsonSerializer.class.isAssignableFrom((Class<?>) rawType)) return null;

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
    private <T> JsonSerializer<T> resolve(final Class<T> clazz) {
        final JsonSerializer<T> serializer = (JsonSerializer<T>) serializers.get(clazz);
        if (serializer != null) return serializer;

        final Class<JsonSerializer<T>> serializerClass = (Class<JsonSerializer<T>>) components.get(clazz);
        if (serializerClass == null) return null;

        for (final Constructor<JsonSerializer<T>> constructor : (Constructor<JsonSerializer<T>>[]) serializerClass.getConstructors()) {
            final ArrayList<Object> args = new ArrayList<Object>();
            boolean success = true;
            for (final Type paramType : constructor.getGenericParameterTypes()) {
                final JsonSerializer<?> serializerParam = resolveSerializerParam(paramType);
                if (serializerParam != null) {
                    args.add(serializerParam);
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
                    final JsonSerializer<T> newSerializer = constructor.newInstance(args.toArray());
                    serializers.put(clazz, newSerializer);
                    return newSerializer;
                } catch (final Exception e) {
                    continue;
                }
            }
        }

        return null;
    }

    @Override
    public <T> String serialize(final T value) {
        final StringWriter writer = new StringWriter();
        try {
            serialize(new JsonWriter(writer), value);
        }
        catch (final IOException e) {
              throw new RuntimeException("Could not serialize object of class: " +
                      value == null ? null : value.getClass().getName(), e);
        }
        return writer.toString();
    }

    @Override
    public <T> void serialize(final OutputStream outputStream, final T value) throws IOException {
        final OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        serialize(new JsonWriter(writer), value);
        writer.flush();
    }

    @SuppressWarnings("unchecked")
    private void serialize(final JsonWriter jsonWriter, final Object value) throws IOException {
        // cover the null condition
        if (value == null) {
            jsonWriter.writeNull();
            return;
        }

        final Class<?> clazz = value.getClass();
        final JsonSerializer<Object> serializer = (JsonSerializer<Object>) resolve(clazz);

        // primitive arrays and other specialized serializers
        if (serializer != null) {
            serializer.toJson(jsonWriter, value);
            return;
        }

        // generic serialization of an array
        if (clazz.isArray()) {
            // cast to Object[] and serialize (cannot be primitive array at this point)
            final Object[] values = (Object[]) value;

            jsonWriter.writeOpenArray();
            boolean needComma = false;
            for (final Object current : values) {
                if (needComma) jsonWriter.writeComma();
                if (current == null) {
                    jsonWriter.writeNull();
                } else {
                    serialize(jsonWriter, current);
                }
                needComma = true;
            }
            jsonWriter.writeCloseArray();
            return;
        }

        // generic serialization of iterable collections
        if (Iterable.class.isAssignableFrom(clazz)) {
            // cast to Iterable<Object> and serialize (Iterable cannot hold primitives)
            final Iterable<Object> values = (Iterable<Object>) value;

            jsonWriter.writeOpenArray();
            boolean needComma = false;
            for (final Object current : values) {
                if (needComma) jsonWriter.writeComma();
                if (current == null) {
                    jsonWriter.writeNull();
                } else {
                    serialize(jsonWriter, current);
                }
                needComma = true;
            }
            jsonWriter.writeCloseArray();
            return;
        }

        // This bit removed from Map block to enable serialization of Iterable<Map.Entry>
        if (Map.Entry.class.isAssignableFrom(clazz)) {
            final Map.Entry<String, Object> entry = (Map.Entry<String, Object>) value;

            serialize(jsonWriter, entry.getKey());
            jsonWriter.writeColon();
            serialize(jsonWriter, entry.getValue());
            return;
        }

        // generic Map serialization - will crash on Maps having keys of class != String
        if (Map.class.isAssignableFrom(clazz)) {
            final Map<String, Object> map = (Map<String, Object>) value;

            jsonWriter.writeOpenObject();
            boolean needComma = false;
            for (final Map.Entry<String, Object> entry : map.entrySet()) {
                if (needComma) jsonWriter.writeComma();
                serialize(jsonWriter, entry);
                needComma = true;
            }
            jsonWriter.writeCloseObject();
            return;
        }

        // Generic enumeration serialization
        if (clazz.isEnum()) {
            final Enum<?> enumeration = (Enum<?>) value;
            jsonWriter.writeString(enumeration.name());
            return;
        }

        // last ditch effort to locate a serializer for a superclass
        for (final Map.Entry<Class<?>, JsonSerializer<?>> entry : serializers.entrySet()) {
            if (entry.getKey().isAssignableFrom(clazz)) {
                ((JsonSerializer<Object>) entry.getValue()).toJson(jsonWriter, value);
                return;
            }
        }

        throw new RuntimeException("Could not locate serializer for object of class: " + clazz.getName());
    }
}
