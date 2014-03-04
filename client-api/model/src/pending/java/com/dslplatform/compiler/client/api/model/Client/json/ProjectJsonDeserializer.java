package com.dslplatform.compiler.client.api.model.Client.json;

import io.jvm.json.JsonDeserializer;
import io.jvm.json.JsonReader;

import java.io.IOException;

import org.slf4j.Logger;

import com.dslplatform.patterns.ServiceLocator;

public class ProjectJsonDeserializer
        implements JsonDeserializer<com.dslplatform.compiler.client.api.model.Client.Project> {

    private final ServiceLocator serviceLocator;
    private final Logger logger;
    private final JsonDeserializer<String> StringJsonDeserializer;
    private final JsonDeserializer<java.util.UUID> UUIDJsonDeserializer;
    private final JsonDeserializer<org.joda.time.DateTime> DateTimeJsonDeserializer;

    public ProjectJsonDeserializer(
            final ServiceLocator serviceLocator,
            final Logger logger,
            final JsonDeserializer<String> StringJsonDeserializer,
            final JsonDeserializer<java.util.UUID> UUIDJsonDeserializer,
            final JsonDeserializer<org.joda.time.DateTime> DateTimeJsonDeserializer) {
        this.serviceLocator = serviceLocator;
        this.logger = logger;
        this.StringJsonDeserializer = StringJsonDeserializer;
        this.UUIDJsonDeserializer = UUIDJsonDeserializer;
        this.DateTimeJsonDeserializer = DateTimeJsonDeserializer;
    }

    private static final com.dslplatform.compiler.client.api.model.Client.Project[] ZERO_ARRAY =
            new com.dslplatform.compiler.client.api.model.Client.Project[0];

    @Override
    public com.dslplatform.compiler.client.api.model.Client.Project[] getZeroArray() {
        return ZERO_ARRAY;
    }

    @Override
    public com.dslplatform.compiler.client.api.model.Client.Project fromJson(final JsonReader jsonReader) throws IOException {
        jsonReader.assertRead('{');
        boolean needComma = false;

        String _URI = null;
        java.util.UUID _ID = null;
        String _Nick = null;
        org.joda.time.DateTime _CreatedAt = null;

        while (jsonReader.read() != '}') {
            if (needComma) jsonReader.assertLast(',');

            final String property = jsonReader.readString();
            jsonReader.assertNext(':');

            if (property.equals("URI")) {
                _URI = StringJsonDeserializer.fromJson(jsonReader);
                needComma = true;
                continue;
            }

            if (property.equals("ID")) {
                _ID = UUIDJsonDeserializer.fromJson(jsonReader);
                needComma = true;
                continue;
            }

            if (property.equals("Nick")) {
                _Nick = jsonReader.readOpt(StringJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("CreatedAt")) {
                _CreatedAt = DateTimeJsonDeserializer.fromJson(jsonReader);
                needComma = true;
                continue;
            }
        }

        return com.dslplatform.compiler.client.api.model.Client.Project._buildInternal(
                serviceLocator,
                _URI,
                _ID,
                _Nick,
                _CreatedAt);
    }
}
