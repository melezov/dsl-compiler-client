package com.dslplatform.compiler.client.api.model.JSONTest.json;

import io.jvm.json.JsonSerializer;
import io.jvm.json.JsonWriter;

import java.io.IOException;

public class StringlyTypedJsonSerializer implements JsonSerializer<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> {
    private final JsonSerializer<String> _StringJsonSerializer;

    public StringlyTypedJsonSerializer(
            final JsonSerializer<String> _StringJsonSerializer) {
        this._StringJsonSerializer = _StringJsonSerializer;
    }

    @Override
    public boolean isDefault(final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped value) {
        final int _ID = value.getID();
        if (_ID != 0) {
            return false;
        }

        final String _oneStr = value.getOneStr();
        if (!_StringJsonSerializer.isDefault(_oneStr)) {
            return false;
        }

        final String _optStr = value.getOptStr();
        if (_optStr != null) {
            return false;
        }

        final String[] _arrStr = value.getArrStr();
        if (_arrStr.length != 0) {
            return false;
        }

        final String[] _arrOptStr = value.getArrOptStr();
        if (_arrOptStr.length != 0) {
            return false;
        }

        final String[] _optArrStr = value.getOptArrStr();
        if (_optArrStr != null) {
            return false;
        }

        final String[] _optArrOptStr = value.getOptArrOptStr();
        if (_optArrOptStr != null) {
            return false;
        }

        final java.util.List<String> _listStr = value.getListStr();
        if (_listStr.size() != 0) {
            return false;
        }

        final java.util.List<String> _listOptStr = value.getListOptStr();
        if (_listOptStr.size() != 0) {
            return false;
        }

        final java.util.List<String> _optListStr = value.getOptListStr();
        if (_optListStr != null) {
            return false;
        }

        final java.util.List<String> _optListOptStr = value.getOptListOptStr();
        if (_optListOptStr != null) {
            return false;
        }


        final java.util.Set<String> _setStr = value.getSetStr();
        if (_setStr.size() != 0) {
            return false;
        }

        final java.util.Set<String> _setOptStr = value.getSetOptStr();
        if (_setOptStr.size() != 0) {
            return false;
        }

        final java.util.Set<String> _optSetStr = value.getOptSetStr();
        if (_optSetStr != null) {
            return false;
        }

        final java.util.Set<String> _optSetOptStr = value.getOptSetOptStr();
        if (_optSetOptStr != null) {
            return false;
        }

        return true;
    }

    @Override
    public void toJson(
            final JsonWriter jsonWriter,
            final com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped value) throws IOException {
        jsonWriter.writeOpenObject();
        boolean needsComma = false;

        final int _ID = value.getID();
        if (_ID != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"ID\":");
//            jsonWriter.writeInt(_ID);
            needsComma = true;
        }

        final String _oneStr = value.getOneStr();
        if (!_StringJsonSerializer.isDefault(_oneStr)) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"oneStr\":");
            _StringJsonSerializer.toJson(jsonWriter, _oneStr);
            needsComma = true;
        }

        final String _optStr = value.getOptStr();
        if (_optStr != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optStr\":");
            _StringJsonSerializer.toJson(jsonWriter, _optStr);
            needsComma = true;
        }

        final String[] _arrStr = value.getArrStr();
        if (_arrStr.length != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"arrStr\":");
            jsonWriter.writeArray(_arrStr, _StringJsonSerializer);
            needsComma = true;
        }

        final String[] _arrOptStr = value.getArrOptStr();
        if (_arrOptStr.length != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"arrOptStr\":");
            jsonWriter.writeArrayOpt(_arrOptStr, _StringJsonSerializer);
            needsComma = true;
        }

        final String[] _optArrStr = value.getOptArrStr();
        if (_optArrStr != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optArrStr\":");
            jsonWriter.writeOptArray(_optArrStr, _StringJsonSerializer);
            needsComma = true;
        }

        final String[] _optArrOptStr = value.getOptArrOptStr();
        if (_optArrOptStr != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optArrOptStr\":");
            jsonWriter.writeOptArrayOpt(_optArrOptStr, _StringJsonSerializer);
            needsComma = true;
        }

        final java.util.List<String> _listStr = value.getListStr();
        if (_listStr.size() != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"listStr\":");
            jsonWriter.writeIterable(_listStr, _StringJsonSerializer);
            needsComma = true;
        }

        final java.util.List<String> _listOptStr = value.getListOptStr();
        if (_listOptStr.size() != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"listOptStr\":");
            jsonWriter.writeIterableOpt(_listOptStr, _StringJsonSerializer);
            needsComma = true;
        }

        final java.util.List<String> _optListStr = value.getOptListStr();
        if (_optListStr != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optListStr\":");
            jsonWriter.writeOptIterable(_optListStr, _StringJsonSerializer);
            needsComma = true;
        }

        final java.util.List<String> _optListOptStr = value.getOptListOptStr();
        if (_optListOptStr != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optListOptStr\":");
            jsonWriter.writeOptIterableOpt(_optListOptStr, _StringJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<String> _setStr = value.getSetStr();
        if (_setStr.size() != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"setStr\":");
            jsonWriter.writeIterable(_setStr, _StringJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<String> _setOptStr = value.getSetOptStr();
        if (_setOptStr.size() != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"setOptStr\":");
            jsonWriter.writeIterableOpt(_setOptStr, _StringJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<String> _optSetStr = value.getOptSetStr();
        if (_optSetStr != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optSetStr\":");
            jsonWriter.writeOptIterable(_optSetStr, _StringJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<String> _optSetOptStr = value.getOptSetOptStr();
        if (_optSetOptStr != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optSetOptStr\":");
            jsonWriter.writeOptIterableOpt(_optSetOptStr, _StringJsonSerializer);
            needsComma = true;
        }

        jsonWriter.writeCloseObject();
    }
}
