package com.dslplatform.compiler.client.api.model.Client.json;

import io.jvm.json.JsonSerializer;
import io.jvm.json.JsonWriter;

import java.io.IOException;

import org.slf4j.Logger;

public class ProjectJsonSerializer
        implements JsonSerializer<com.dslplatform.compiler.client.api.model.Client.Project> {

    private final Logger logger;
    private final JsonSerializer<String> StringJsonSerializer;
    private final JsonSerializer<java.util.UUID> UUIDJsonSerializer;
    private final JsonSerializer<org.joda.time.DateTime> DateTimeJsonSerializer;

    public ProjectJsonSerializer(
            final Logger logger,
            final JsonSerializer<String> StringJsonSerializer,
            final JsonSerializer<java.util.UUID> UUIDJsonSerializer,
            final JsonSerializer<org.joda.time.DateTime> DateTimeJsonSerializer) {
        this.logger = logger;
        this.StringJsonSerializer = StringJsonSerializer;
        this.UUIDJsonSerializer = UUIDJsonSerializer;
        this.DateTimeJsonSerializer = DateTimeJsonSerializer;
    }

    @Override
    public boolean isDefault(final com.dslplatform.compiler.client.api.model.Client.Project value) {
        return false;
    }

    @Override
    public void toJson(
            final JsonWriter jsonWriter,
            final com.dslplatform.compiler.client.api.model.Client.Project value) throws IOException {
        jsonWriter.writeOpenObject();
        boolean needsComma = false;

        final java.util.UUID _ID = value.getID();
        if (!UUIDJsonSerializer.isDefault(_ID)) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"ID\":");
            UUIDJsonSerializer.toJson(jsonWriter, _ID);
            needsComma = true;
        }

        final String _Nick = value.getNick();
        if (_Nick != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"Nick\":");
            jsonWriter.writeOpt(_Nick, StringJsonSerializer);
            needsComma = true;
        }

        final org.joda.time.DateTime _CreatedAt = value.getCreatedAt();
        if (!DateTimeJsonSerializer.isDefault(_CreatedAt)) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"CreatedAt\":");
            DateTimeJsonSerializer.toJson(jsonWriter, _CreatedAt);
            needsComma = true;
        }

        jsonWriter.writeCloseObject();
    }
}
