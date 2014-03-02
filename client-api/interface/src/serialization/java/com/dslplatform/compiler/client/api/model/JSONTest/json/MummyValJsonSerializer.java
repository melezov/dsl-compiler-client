package com.dslplatform.compiler.client.api.model.JSONTest.json;

import io.jvm.json.JsonSerializer;
import io.jvm.json.JsonWriter;

import java.io.IOException;

public class MummyValJsonSerializer implements JsonSerializer<com.dslplatform.compiler.client.api.model.JSONTest.MummyVal> {
    private final JsonSerializer<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _LongLegsJsonSerializer;

    public MummyValJsonSerializer(
            final JsonSerializer<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _LongLegsJsonSerializer) {
        this._LongLegsJsonSerializer = _LongLegsJsonSerializer;
    }

    @Override
    public boolean isDefault(final com.dslplatform.compiler.client.api.model.JSONTest.MummyVal value) {
        final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs _oneLL = value.getOneLL();
        if (!_LongLegsJsonSerializer.isDefault(_oneLL)) {
            return false;
        }

        final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs _optLL = value.getOptLL();
        if (_optLL != null) {
            return false;
        }

        final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] _arrLL = value.getArrLL();
        if (_arrLL.length != 0) {
            return false;
        }

        final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] _arrOptLL = value.getArrOptLL();
        if (_arrOptLL.length != 0) {
            return false;
        }

        final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] _optArrLL = value.getOptArrLL();
        if (_optArrLL != null) {
            return false;
        }

        final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] _optArrOptLL = value.getOptArrOptLL();
        if (_optArrOptLL != null) {
            return false;
        }

        final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _listLL = value.getListLL();
        if (_listLL.size() != 0) {
            return false;
        }

        final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _listOptLL = value.getListOptLL();
        if (_listOptLL.size() != 0) {
            return false;
        }

        final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _optListLL = value.getOptListLL();
        if (_optListLL != null) {
            return false;
        }

        final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _optListOptLL = value.getOptListOptLL();
        if (_optListOptLL != null) {
            return false;
        }


        final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _setLL = value.getSetLL();
        if (_setLL.size() != 0) {
            return false;
        }

        final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _setOptLL = value.getSetOptLL();
        if (_setOptLL.size() != 0) {
            return false;
        }

        final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _optSetLL = value.getOptSetLL();
        if (_optSetLL != null) {
            return false;
        }

        final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _optSetOptLL = value.getOptSetOptLL();
        if (_optSetOptLL != null) {
            return false;
        }

        return true;
    }

    @Override
    public void toJson(
            final JsonWriter jsonWriter,
            final com.dslplatform.compiler.client.api.model.JSONTest.MummyVal value) throws IOException {
        jsonWriter.writeOpenObject();
        boolean needsComma = false;

        final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs _oneLL = value.getOneLL();
        if (!_LongLegsJsonSerializer.isDefault(_oneLL)) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"oneLL\":");
            _LongLegsJsonSerializer.toJson(jsonWriter, _oneLL);
            needsComma = true;
        }

        final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs _optLL = value.getOptLL();
        if (_optLL != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optLL\":");
            _LongLegsJsonSerializer.toJson(jsonWriter, _optLL);
            needsComma = true;
        }

        final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] _arrLL = value.getArrLL();
        if (_arrLL.length != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"arrLL\":");
            jsonWriter.writeArray(_arrLL, _LongLegsJsonSerializer);
            needsComma = true;
        }

        final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] _arrOptLL = value.getArrOptLL();
        if (_arrOptLL.length != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"arrOptLL\":");
            jsonWriter.writeArrayOpt(_arrOptLL, _LongLegsJsonSerializer);
            needsComma = true;
        }

        final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] _optArrLL = value.getOptArrLL();
        if (_optArrLL != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optArrLL\":");
            jsonWriter.writeOptArray(_optArrLL, _LongLegsJsonSerializer);
            needsComma = true;
        }

        final com.dslplatform.compiler.client.api.model.JSONTest.LongLegs[] _optArrOptLL = value.getOptArrOptLL();
        if (_optArrOptLL != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optArrOptLL\":");
            jsonWriter.writeOptArrayOpt(_optArrOptLL, _LongLegsJsonSerializer);
            needsComma = true;
        }

        final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _listLL = value.getListLL();
        if (_listLL.size() != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"listLL\":");
            jsonWriter.writeIterable(_listLL, _LongLegsJsonSerializer);
            needsComma = true;
        }

        final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _listOptLL = value.getListOptLL();
        if (_listOptLL.size() != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"listOptLL\":");
            jsonWriter.writeIterableOpt(_listOptLL, _LongLegsJsonSerializer);
            needsComma = true;
        }

        final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _optListLL = value.getOptListLL();
        if (_optListLL != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optListLL\":");
            jsonWriter.writeOptIterable(_optListLL, _LongLegsJsonSerializer);
            needsComma = true;
        }

        final java.util.List<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _optListOptLL = value.getOptListOptLL();
        if (_optListOptLL != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optListOptLL\":");
            jsonWriter.writeOptIterableOpt(_optListOptLL, _LongLegsJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _setLL = value.getSetLL();
        if (_setLL.size() != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"setLL\":");
            jsonWriter.writeIterable(_setLL, _LongLegsJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _setOptLL = value.getSetOptLL();
        if (_setOptLL.size() != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"setOptLL\":");
            jsonWriter.writeIterableOpt(_setOptLL, _LongLegsJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _optSetLL = value.getOptSetLL();
        if (_optSetLL != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optSetLL\":");
            jsonWriter.writeOptIterable(_optSetLL, _LongLegsJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<com.dslplatform.compiler.client.api.model.JSONTest.LongLegs> _optSetOptLL = value.getOptSetOptLL();
        if (_optSetOptLL != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optSetOptLL\":");
            jsonWriter.writeOptIterableOpt(_optSetOptLL, _LongLegsJsonSerializer);
            needsComma = true;
        }

        jsonWriter.writeCloseObject();
    }
}
