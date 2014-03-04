package com.dslplatform.client.serialization.json;

import io.jvm.json.JsonDeserializer;
import io.jvm.json.JsonSerializer;
import io.jvm.json.deserializers.BigDecimalJsonDeserializer;
import io.jvm.json.deserializers.BigIntegerJsonDeserializer;
import io.jvm.json.deserializers.BooleanArrayJsonDeserializer;
import io.jvm.json.deserializers.BooleanJsonDeserializer;
import io.jvm.json.deserializers.ByteArrayJsonDeserializer;
import io.jvm.json.deserializers.ByteJsonDeserializer;
import io.jvm.json.deserializers.CharArrayJsonDeserializer;
import io.jvm.json.deserializers.CharacterJsonDeserializer;
import io.jvm.json.deserializers.DateTimeJsonDeserializer;
import io.jvm.json.deserializers.DoubleArrayJsonDeserializer;
import io.jvm.json.deserializers.DoubleJsonDeserializer;
import io.jvm.json.deserializers.FloatArrayJsonDeserializer;
import io.jvm.json.deserializers.FloatJsonDeserializer;
import io.jvm.json.deserializers.IntArrayJsonDeserializer;
import io.jvm.json.deserializers.IntegerJsonDeserializer;
import io.jvm.json.deserializers.LocalDateJsonDeserializer;
import io.jvm.json.deserializers.LongArrayJsonDeserializer;
import io.jvm.json.deserializers.LongJsonDeserializer;
import io.jvm.json.deserializers.ShortArrayJsonDeserializer;
import io.jvm.json.deserializers.ShortJsonDeserializer;
import io.jvm.json.deserializers.StringJsonDeserializer;
import io.jvm.json.deserializers.UUIDJsonDeserializer;
import io.jvm.json.serializers.BigDecimalJsonSerializer;
import io.jvm.json.serializers.BigIntegerJsonSerializer;
import io.jvm.json.serializers.BooleanArrayJsonSerializer;
import io.jvm.json.serializers.BooleanJsonSerializer;
import io.jvm.json.serializers.ByteArrayJsonSerializer;
import io.jvm.json.serializers.ByteJsonSerializer;
import io.jvm.json.serializers.CharArrayJsonSerializer;
import io.jvm.json.serializers.CharacterJsonSerializer;
import io.jvm.json.serializers.DateTimeJsonSerializer;
import io.jvm.json.serializers.DoubleArrayJsonSerializer;
import io.jvm.json.serializers.DoubleJsonSerializer;
import io.jvm.json.serializers.FloatArrayJsonSerializer;
import io.jvm.json.serializers.FloatJsonSerializer;
import io.jvm.json.serializers.IntArrayJsonSerializer;
import io.jvm.json.serializers.IntegerJsonSerializer;
import io.jvm.json.serializers.LocalDateJsonSerializer;
import io.jvm.json.serializers.LongArrayJsonSerializer;
import io.jvm.json.serializers.LongJsonSerializer;
import io.jvm.json.serializers.ShortArrayJsonSerializer;
import io.jvm.json.serializers.ShortJsonSerializer;
import io.jvm.json.serializers.StringJsonSerializer;
import io.jvm.json.serializers.UUIDJsonSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

import com.dslplatform.client.serialization.Deserialization;
import com.dslplatform.client.serialization.Serialization;
import com.dslplatform.patterns.ServiceLocator;

public class JsonMapper implements Serialization<String>, Deserialization<String> {
    protected final JsonSerialization jsonSerialization;
    protected final JsonDeserialization jsonDeserialization;

    public JsonMapper(final ServiceLocator serviceLocator) {
        this.jsonSerialization = new JsonSerialization(serviceLocator)
            .register(ByteJsonSerializer.class)
            .register(ByteArrayJsonSerializer.class)
            .register(ShortJsonSerializer.class)
            .register(ShortArrayJsonSerializer.class)
            .register(IntegerJsonSerializer.class)
            .register(IntArrayJsonSerializer.class)
            .register(LongJsonSerializer.class)
            .register(LongArrayJsonSerializer.class)
            .register(FloatJsonSerializer.class)
            .register(FloatArrayJsonSerializer.class)
            .register(DoubleJsonSerializer.class)
            .register(DoubleArrayJsonSerializer.class)
            .register(BooleanJsonSerializer.class)
            .register(BooleanArrayJsonSerializer.class)
            .register(CharacterJsonSerializer.class)
            .register(CharArrayJsonSerializer.class)

            .register(BigDecimalJsonSerializer.class)
            .register(BigIntegerJsonSerializer.class)
            .register(DateTimeJsonSerializer.class)
            .register(LocalDateJsonSerializer.class)
            .register(StringJsonSerializer.class)
            .register(UUIDJsonSerializer.class);

        this.jsonDeserialization = new JsonDeserialization(serviceLocator)
            .register(ByteJsonDeserializer.class)
            .register(ByteArrayJsonDeserializer.class)
            .register(ShortJsonDeserializer.class)
            .register(ShortArrayJsonDeserializer.class)
            .register(IntegerJsonDeserializer.class)
            .register(IntArrayJsonDeserializer.class)
            .register(LongJsonDeserializer.class)
            .register(LongArrayJsonDeserializer.class)
            .register(FloatJsonDeserializer.class)
            .register(FloatArrayJsonDeserializer.class)
            .register(DoubleJsonDeserializer.class)
            .register(DoubleArrayJsonDeserializer.class)
            .register(BooleanJsonDeserializer.class)
            .register(BooleanArrayJsonDeserializer.class)
            .register(CharacterJsonDeserializer.class)
            .register(CharArrayJsonDeserializer.class)

            .register(BigDecimalJsonDeserializer.class)
            .register(BigIntegerJsonDeserializer.class)
            .register(DateTimeJsonDeserializer.class)
            .register(LocalDateJsonDeserializer.class)
            .register(StringJsonDeserializer.class)
            .register(UUIDJsonDeserializer.class);
    }

    protected JsonMapper registerSerializer(final JsonSerializer<?> serializer) {
        jsonSerialization.register(serializer);
        return null;
    }

    protected void registerSerializer(final Class<? extends JsonSerializer<?>> serializerClass) {
        jsonSerialization.register(serializerClass);
    }

    protected void registerDeserializer(final JsonDeserializer<?> deserializer) {
        jsonDeserialization.register(deserializer);
    }

    protected void registerDeserializer(final Class<? extends JsonDeserializer<?>> deserializerClass) {
        jsonDeserialization.register(deserializerClass);
    }

    @Override
    public <T> void serialize(final OutputStream outputStream, final T value) throws IOException {
        jsonSerialization.serialize(outputStream, value);
    }

    @Override
    public <T> String serialize(final T value) {
        return jsonSerialization.serialize(value);
    }

    @Override
    public <T> T deserialize(final InputStream inputStream, final Class<T> clazz) throws IOException {
        return jsonDeserialization.deserialize(inputStream, clazz);
    }

    @Override
    public <T> T deserialize(final String value, final Class<T> clazz) {
        return jsonDeserialization.deserialize(value, clazz);
    }

    @Override
    public <T, C extends Collection<T>> C deserialize(final InputStream inputStream, final Class<T> clazz, final C builder)
            throws IOException {
        return jsonDeserialization.deserialize(inputStream, clazz, builder);
    }

    @Override
    public <T, C extends Collection<T>> C deserialize(final String value, final Class<T> clazz, final C builder) {
        return jsonDeserialization.deserialize(value, clazz, builder);
    }
}
