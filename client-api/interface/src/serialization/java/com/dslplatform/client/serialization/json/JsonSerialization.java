package com.dslplatform.client.serialization.json;

import io.jvm.json.JsonSerializer;
import io.jvm.json.JsonWriter;
import io.jvm.json.serializers.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashMap;
import java.util.Map;

import com.dslplatform.client.serialization.Serialization;

public class JsonSerialization implements Serialization<String> {
    private final Map<Class<Object>, JsonSerializer<Object>> serializers;

    public JsonSerialization() {
        serializers = new LinkedHashMap<>();

        register(new ByteJsonSerializer())
        .register(new ByteArrayJsonSerializer())
        .register(new ShortJsonSerializer())
        .register(new ShortArrayJsonSerializer())
        .register(new IntegerJsonSerializer())
        .register(new IntArrayJsonSerializer())
        .register(new LongJsonSerializer())
        .register(new LongArrayJsonSerializer())
        .register(new FloatJsonSerializer())
        .register(new FloatArrayJsonSerializer())
        .register(new DoubleJsonSerializer())
        .register(new DoubleArrayJsonSerializer())
        .register(new BooleanJsonSerializer())
        .register(new BooleanArrayJsonSerializer())
        .register(new CharacterJsonSerializer())
        .register(new CharArrayJsonSerializer())

        .register(new BigDecimalJsonSerializer())
        .register(new BigIntegerJsonSerializer())
        .register(new DateTimeJsonSerializer())
        .register(new LocalDateJsonSerializer())
        .register(new StringJsonSerializer())
        .register(new UUIDJsonSerializer());
    }

    @SuppressWarnings("unchecked")
    public JsonSerialization register(final JsonSerializer<?> serializer) {
        final ParameterizedType paramType = (ParameterizedType) (serializer.getClass().getGenericInterfaces()[0]);
        final Class<Object> clazz = (Class<Object>) paramType.getActualTypeArguments()[0];
        serializers.put(clazz, (JsonSerializer<Object>) serializer);
        return this;
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
        final JsonSerializer<Object> serializer = (JsonSerializer<Object>) serializers.get(clazz);

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
        for (final Map.Entry<Class<Object>, JsonSerializer<Object>> entry : serializers.entrySet()) {
            if (entry.getKey().isAssignableFrom(clazz)) {
                entry.getValue().toJson(jsonWriter, value);
                return;
            }
        }

        throw new RuntimeException("Could not locate serializer for object of class: " + clazz.getName());
    }
}
