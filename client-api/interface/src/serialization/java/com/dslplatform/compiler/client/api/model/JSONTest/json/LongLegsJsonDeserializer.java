package com.dslplatform.compiler.client.api.model.JSONTest.json;

import io.jvm.json.JsonDeserializer;
import io.jvm.json.JsonReader;

import java.io.IOException;

import org.slf4j.Logger;

public class LongLegsJsonDeserializer implements JsonDeserializer<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> {
    private final Logger logger;
    private final JsonDeserializer<Long> LongJsonDeserializer;
    private final JsonDeserializer<long[]> LongArrayJsonDeserializer;

    public LongLegsJsonDeserializer(
            final Logger logger,
            final JsonDeserializer<Long> LongJsonDeserializer,
            final JsonDeserializer<long[]> LongArrayJsonDeserializer) {
        this.logger = logger;
        this.LongJsonDeserializer = LongJsonDeserializer;
        this.LongArrayJsonDeserializer = LongArrayJsonDeserializer;
    }

    private static final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] ZERO_ARRAY =
            new com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[0];

    @Override
    public com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] getZeroArray() {
        return ZERO_ARRAY;
    }

    @Override
    public com.dslplatform.compiler.client.api.model.JSONTest.LongLegs fromJson(final JsonReader jsonReader) throws IOException {
        jsonReader.assertRead('{');
        boolean needComma = false;

        long oneLong = 0L;
        Long optLong = null;
        long[] arrLong = null;
        Long[] arrOptLong = null;
        long[] optArrLong = null;
        Long[] optArrOptLong = null;
        java.util.List<Long> listLong = null;
        java.util.List<Long> listOptLong = null;
        java.util.List<Long> optListLong = null;
        java.util.List<Long> optListOptLong = null;
        java.util.Set<Long> setLong = null;
        java.util.Set<Long> setOptLong = null;
        java.util.Set<Long> optSetLong = null;
        java.util.Set<Long> optSetOptLong = null;

        while (jsonReader.read() != '}') {
            if (needComma) jsonReader.assertLast(',');

            final String property = jsonReader.readString();
            jsonReader.assertNext(':');

            if (property.equals("oneLong")) {
                oneLong = LongJsonDeserializer.fromJson(jsonReader);
                needComma = true;
                continue;
            }

            if (property.equals("optLong")) {
                optLong = jsonReader.readOpt(LongJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("arrLong")) {
                arrLong = LongArrayJsonDeserializer.fromJson(jsonReader);
                needComma = true;
                continue;
            }

            if (property.equals("arrOptLong")) {
                arrOptLong = jsonReader.readArrayOpt(LongJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optArrLong")) {
                optArrLong = jsonReader.readOpt(LongArrayJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optArrOptLong")) {
                optArrOptLong = jsonReader.readOptArrayOpt(LongJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("listLong")) {
                listLong = jsonReader.readList(LongJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("listOptLong")) {
                listOptLong = jsonReader.readListOpt(LongJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optListLong")) {
                optListLong = jsonReader.readOptList(LongJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optListOptLong")) {
                optListOptLong = jsonReader.readOptListOpt(LongJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("setLong")) {
                setLong = jsonReader.readSet(LongJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("setOptLong")) {
                setOptLong = jsonReader.readSetOpt(LongJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optSetLong")) {
                optSetLong = jsonReader.readOptSet(LongJsonDeserializer);
                needComma = true;
                continue;
            }

            if (property.equals("optSetOptLong")) {
                optSetOptLong = jsonReader.readOptSetOpt(LongJsonDeserializer);
                needComma = true;
                continue;
            }
        }

        jsonReader.invalidate();

        return new com.dslplatform.compiler.client.api.model.JSONTest.LongLegs(
                oneLong,
                optLong,
                arrLong != null ? arrLong : new long[0],
                arrOptLong != null ? arrOptLong : new Long[0],
                optArrLong,
                optArrOptLong,
                listLong != null ? listLong : new java.util.ArrayList<Long>(),
                listOptLong != null ? listOptLong : new java.util.ArrayList<Long>(),
                optListLong,
                optListOptLong,
                setLong != null ? setLong : new java.util.HashSet<Long>(),
                setOptLong != null ? setOptLong : new java.util.HashSet<Long>(),
                optSetLong,
                optSetOptLong);
    }
}
