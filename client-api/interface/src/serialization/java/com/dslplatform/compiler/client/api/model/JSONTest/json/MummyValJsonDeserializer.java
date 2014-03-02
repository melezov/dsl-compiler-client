package com.dslplatform.compiler.client.api.model.JSONTest.json;

import io.jvm.json.JsonDeserializer;
import io.jvm.json.JsonReader;

import java.io.IOException;

import org.slf4j.Logger;

public class MummyValJsonDeserializer implements JsonDeserializer<com.dslplatform.compiler.client.api.model.JSONTest.MummyVal> {
    private final Logger logger;
    private final JsonDeserializer<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _LongLegsJsonDeserializer;

    public MummyValJsonDeserializer(
            final Logger logger,
            final JsonDeserializer<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _LongLegsJsonDeserializer) {
        this.logger = logger;
        this._LongLegsJsonDeserializer =_LongLegsJsonDeserializer;
    }

    private static final com.dslplatform.compiler.client.api.model.JSONTest.MummyVal[] ZERO_ARRAY =
            new com.dslplatform.compiler.client.api.model.JSONTest.MummyVal[0];

    @Override
    public com.dslplatform.compiler.client.api.model.JSONTest.MummyVal[] getZeroArray() {
        return ZERO_ARRAY;
    }

    @Override
    public com.dslplatform.compiler.client.api.model.JSONTest.MummyVal fromJson(final JsonReader jsonReader) throws IOException {
        jsonReader.assertRead('{');
        boolean needComma = false;

        com.dslplatform.compiler.client.api.model.JSONTest.LongLegs oneLL = null;
        com.dslplatform.compiler.client.api.model.JSONTest.LongLegs optLL = null;
        com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] arrLL = null;
        com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] arrOptLL = null;
        com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] optArrLL = null;
        com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] optArrOptLL = null;
        java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> listLL = null;
        java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> listOptLL = null;
        java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> optListLL = null;
        java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> optListOptLL = null;
        java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> setLL = null;
        java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> setOptLL = null;
        java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> optSetLL = null;
        java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> optSetOptLL = null;

        while (jsonReader.read() != '}') {
            if (needComma) jsonReader.assertLast(',');

            final String property = jsonReader.readString();
            jsonReader.assertNext(':');

            if (property.equals("oneLL")) {
                oneLL = _LongLegsJsonDeserializer.fromJson(jsonReader);
                needComma = true;
                continue;
            }

            if (property.equals("optLL")) {
                optLL = jsonReader.readOpt(_LongLegsJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("arrLL")) {
                arrLL = jsonReader.readArray(_LongLegsJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("arrOptLL")) {
                arrOptLL = jsonReader.readArrayOpt(_LongLegsJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optArrLL")) {
                optArrLL = jsonReader.readOptArray(_LongLegsJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optArrOptLL")) {
                optArrOptLL = jsonReader.readOptArrayOpt(_LongLegsJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("listLL")) {
                listLL = jsonReader.readList(_LongLegsJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("listOptLL")) {
                listOptLL = jsonReader.readListOpt(_LongLegsJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optListLL")) {
                optListLL = jsonReader.readOptList(_LongLegsJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optListOptLL")) {
                optListOptLL = jsonReader.readOptListOpt(_LongLegsJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("setLL")) {
                setLL = jsonReader.readSet(_LongLegsJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("setOptLL")) {
                setOptLL = jsonReader.readSetOpt(_LongLegsJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optSetLL")) {
                optSetLL = jsonReader.readOptSet(_LongLegsJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optSetOptLL")) {
                optSetOptLL = jsonReader.readOptSetOpt(_LongLegsJsonDeserializer);
                needComma = true;
                continue;
            }
        }

        jsonReader.invalidate();

        return new com.dslplatform.compiler.client.api.model.JSONTest.MummyVal(
                oneLL != null ? oneLL : new com.dslplatform.compiler.client.api.model.JSONTest.LongLegs(),
                optLL,
                arrLL != null ? arrLL : new com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[0],
                arrOptLL != null ? arrOptLL : new com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[0],
                optArrLL,
                optArrOptLL,
                listLL != null ? listLL : new java.util.ArrayList<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs>(),
                listOptLL != null ? listOptLL : new java.util.ArrayList<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs>(),
                optListLL,
                optListOptLL,
                setLL != null ? setLL : new java.util.HashSet<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs>(),
                setOptLL != null ? setOptLL : new java.util.HashSet<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs>(),
                optSetLL,
                optSetOptLL);
    }
}
