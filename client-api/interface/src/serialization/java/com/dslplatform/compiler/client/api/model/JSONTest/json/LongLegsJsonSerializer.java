package com.dslplatform.compiler.client.api.model.JSONTest.json;

import io.jvm.json.JsonSerializer;
import io.jvm.json.JsonWriter;

import java.io.IOException;

public class LongLegsJsonSerializer implements JsonSerializer<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> {
    private final JsonSerializer<Long> _LongJsonSerializer;
    private final JsonSerializer<long[]> _LongArrayJsonSerializer;

    public LongLegsJsonSerializer(
            final JsonSerializer<Long> _LongJsonSerializer,
        final JsonSerializer<long[]> _LongArrayJsonSerializer) {
        this._LongJsonSerializer = _LongJsonSerializer;
        this._LongArrayJsonSerializer = _LongArrayJsonSerializer;
    }

    @Override
    public boolean isDefault(final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs value) {
        final long _oneLong = value.getOneLong();
        if (_oneLong != 0L) {
            return false;
        }

        final Long _optLong = value.getOptLong();
        if (_optLong != null) {
            return false;
        }

        final long[] _arrLong = value.getArrLong();
        if (_arrLong.length != 0) {
            return false;
        }

        final Long[] _arrOptLong = value.getArrOptLong();
        if (_arrOptLong.length != 0) {
            return false;
        }

        final long[] _optArrLong = value.getOptArrLong();
        if (_optArrLong != null) {
            return false;
        }

        final Long[] _optArrOptLong = value.getOptArrOptLong();
        if (_optArrOptLong != null) {
            return false;
        }

        final java.util.List<Long> _listLong = value.getListLong();
        if (!_listLong.isEmpty()) {
            return false;
        }

        final java.util.List<Long> _listOptLong = value.getListOptLong();
        if (!_listOptLong.isEmpty()) {
            return false;
        }

        final java.util.List<Long> _optListLong = value.getOptListLong();
        if (_optListLong != null) {
            return false;
        }

        final java.util.List<Long> _optListOptLong = value.getOptListOptLong();
        if (_optListOptLong != null) {
            return false;
        }

        final java.util.Set<Long> _setLong = value.getSetLong();
        if (!_setLong.isEmpty()) {
            return false;
        }

        final java.util.Set<Long> _setOptLong = value.getSetOptLong();
        if (!_setOptLong.isEmpty()) {
            return false;
        }

        final java.util.Set<Long> _optSetLong = value.getOptSetLong();
        if (_optSetLong != null) {
            return false;
        }

        final java.util.Set<Long> _optSetOptLong = value.getOptSetOptLong();
        if (_optSetOptLong != null) {
            return false;
        }

        return true;
    }

    @Override
    public void toJson(
            final JsonWriter jsonWriter,
            final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs value) throws IOException {
        jsonWriter.writeOpenObject();
        boolean needsComma = false;

        final long _oneLong = value.getOneLong();
        if (_oneLong != 0L) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"oneLong\":");
            _LongJsonSerializer.toJson(jsonWriter, _oneLong);
            needsComma = true;
        }

        final Long _optLong = value.getOptLong();
        if (_optLong != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optLong\":");
            _LongJsonSerializer.toJson(jsonWriter, _oneLong);
            needsComma = true;
        }

        final long[] _arrLong = value.getArrLong();
        if (_arrLong.length != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"arrLong\":");
            _LongArrayJsonSerializer.toJson(jsonWriter, _arrLong);
            needsComma = true;
        }

        final Long[] _arrOptLong = value.getArrOptLong();
        if (_arrOptLong.length != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"arrOptLong\":");
            jsonWriter.writeArrayOpt(_arrOptLong, _LongJsonSerializer);
            needsComma = true;
        }

        final long[] _optArrLong = value.getOptArrLong();
        if (_optArrLong != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optArrLong\":");
            jsonWriter.writeOpt(_optArrLong, _LongArrayJsonSerializer);
            needsComma = true;
        }

        final Long[] _optArrOptLong = value.getOptArrOptLong();
        if (_optArrOptLong != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optArrOptLong\":");
            jsonWriter.writeOptArrayOpt(_optArrOptLong, _LongJsonSerializer);
            needsComma = true;
        }

        final java.util.List<Long> _listLong = value.getListLong();
        if (!_listLong.isEmpty()) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"listLong\":");
            jsonWriter.writeIterable(_listLong, _LongJsonSerializer);
            needsComma = true;
        }

        final java.util.List<Long> _listOptLong = value.getListOptLong();
        if (!_listOptLong.isEmpty()) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"listOptLong\":");
            jsonWriter.writeIterable(_listOptLong, _LongJsonSerializer);
            needsComma = true;
        }

        final java.util.List<Long> _optListLong = value.getOptListLong();
        if (_optListLong != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optListLong\":");
            jsonWriter.writeIterable(_optListLong, _LongJsonSerializer);
            needsComma = true;
        }

        final java.util.List<Long> _optListOptLong = value.getOptListOptLong();
        if (_optListOptLong != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optListOptLong\":");
            jsonWriter.writeIterable(_optListOptLong, _LongJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<Long> _setLong = value.getSetLong();
        if (!_setLong.isEmpty()) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"setLong\":");
            jsonWriter.writeIterable(_setLong, _LongJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<Long> _setOptLong = value.getSetOptLong();
        if (!_setOptLong.isEmpty()) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"setOptLong\":");
            jsonWriter.writeIterableOpt(_setOptLong, _LongJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<Long> _optSetLong = value.getOptSetLong();
        if (_optSetLong != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optSetLong\":");
            jsonWriter.writeOptIterable(_optSetLong, _LongJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<Long> _optSetOptLong = value.getOptSetOptLong();
        if (_optSetOptLong != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optSetOptLong\":");
            jsonWriter.writeOptIterableOpt(_optSetOptLong, _LongJsonSerializer);
            needsComma = true;
        }

        jsonWriter.writeCloseObject();
    }
}
