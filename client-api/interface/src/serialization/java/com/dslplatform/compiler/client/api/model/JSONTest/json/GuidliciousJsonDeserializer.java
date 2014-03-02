package com.dslplatform.compiler.client.api.model.JSONTest.json;

import io.jvm.json.JsonDeserializer;
import io.jvm.json.JsonReader;

import java.io.IOException;

import org.slf4j.Logger;

public class GuidliciousJsonDeserializer implements JsonDeserializer<com.dslplatform.compiler.client.api.model.JSONTest.Guidlicious> {
    private final Logger logger;
    private final JsonDeserializer<java.util.UUID> _UUIDJsonDeserializer;

    public GuidliciousJsonDeserializer(
            final Logger logger,
            final JsonDeserializer<java.util.UUID> _UUIDJsonDeserializer) {
        this.logger = logger;
        this._UUIDJsonDeserializer =_UUIDJsonDeserializer;
    }

    private static final com.dslplatform.compiler.client.api.model.JSONTest.Guidlicious[] ZERO_ARRAY =
            new com.dslplatform.compiler.client.api.model.JSONTest.Guidlicious[0];

    @Override
    public com.dslplatform.compiler.client.api.model.JSONTest.Guidlicious[] getZeroArray() {
        return ZERO_ARRAY;
    }

    @Override
    public com.dslplatform.compiler.client.api.model.JSONTest.Guidlicious fromJson(final JsonReader jsonReader) throws IOException {
        jsonReader.assertRead('{');
        boolean needComma = false;

        java.util.UUID oneGuid = null;
        java.util.UUID optGuid = null;
        java.util.UUID[] arrGuid = null;
        java.util.UUID[] arrOptGuid = null;
        java.util.UUID[] optArrGuid = null;
        java.util.UUID[] optArrOptGuid = null;
        java.util.List<java.util.UUID> listGuid = null;
        java.util.List<java.util.UUID> listOptGuid = null;
        java.util.List<java.util.UUID> optListGuid = null;
        java.util.List<java.util.UUID> optListOptGuid = null;
        java.util.Set<java.util.UUID> setGuid = null;
        java.util.Set<java.util.UUID> setOptGuid = null;
        java.util.Set<java.util.UUID> optSetGuid = null;
        java.util.Set<java.util.UUID> optSetOptGuid = null;

        while (jsonReader.read() != '}') {
            if (needComma) jsonReader.assertLast(',');

            final String property = jsonReader.readString();
            jsonReader.assertNext(':');

            if (property.equals("oneGuid")) {
                oneGuid = _UUIDJsonDeserializer.fromJson(jsonReader);
                needComma = true;
                continue;
            }

            if (property.equals("optGuid")) {
                optGuid = jsonReader.readOpt(_UUIDJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("arrGuid")) {
                arrGuid = jsonReader.readArray(_UUIDJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("arrOptGuid")) {
                arrOptGuid = jsonReader.readArrayOpt(_UUIDJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optArrGuid")) {
                optArrGuid = jsonReader.readOptArray(_UUIDJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optArrOptGuid")) {
                optArrOptGuid = jsonReader.readOptArrayOpt(_UUIDJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("listGuid")) {
                listGuid = jsonReader.readList(_UUIDJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("listOptGuid")) {
                listOptGuid = jsonReader.readListOpt(_UUIDJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optListGuid")) {
                optListGuid = jsonReader.readOptList(_UUIDJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optListOptGuid")) {
                optListOptGuid = jsonReader.readOptListOpt(_UUIDJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("setGuid")) {
                setGuid = jsonReader.readSet(_UUIDJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("setOptGuid")) {
                setOptGuid = jsonReader.readSetOpt(_UUIDJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optSetGuid")) {
                optSetGuid = jsonReader.readOptSet(_UUIDJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optSetOptGuid")) {
                optSetOptGuid = jsonReader.readOptSetOpt(_UUIDJsonDeserializer);
                needComma = true;
                continue;
            }
        }

        jsonReader.invalidate();

        return new com.dslplatform.compiler.client.api.model.JSONTest.Guidlicious(
                oneGuid != null ? oneGuid : java.util.UUID.randomUUID(),
                optGuid,
                arrGuid != null ? arrGuid : new java.util.UUID[0],
                arrOptGuid != null ? arrOptGuid : new java.util.UUID[0],
                optArrGuid,
                optArrOptGuid,
                listGuid != null ? listGuid : new java.util.ArrayList<java.util.UUID>(),
                listOptGuid != null ? listOptGuid : new java.util.ArrayList<java.util.UUID>(),
                optListGuid,
                optListOptGuid,
                setGuid != null ? setGuid : new java.util.HashSet<java.util.UUID>(),
                setOptGuid != null ? setOptGuid : new java.util.HashSet<java.util.UUID>(),
                optSetGuid,
                optSetOptGuid);
    }
}
