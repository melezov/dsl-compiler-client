package com.dslplatform.compiler.client.api.model.JSONTest.json;

import io.jvm.json.JsonSerializer;
import io.jvm.json.JsonWriter;

import java.io.IOException;

public class GuidliciousJsonSerializer implements JsonSerializer<com.dslplatform.compiler.client.api.model.JSONTest.Guidlicious> {
    private final JsonSerializer<java.util.UUID> _UUIDJsonSerializer;

    public GuidliciousJsonSerializer(
            final JsonSerializer<java.util.UUID> _UUIDJsonSerializer) {
        this._UUIDJsonSerializer = _UUIDJsonSerializer;
    }

    @Override
    public boolean isDefault(final com.dslplatform.compiler.client.api.model.JSONTest.Guidlicious value) {
        final java.util.UUID _oneGuid = value.getOneGuid();
        if (!_UUIDJsonSerializer.isDefault(_oneGuid)) {
            return false;
        }

        final java.util.UUID _optGuid = value.getOptGuid();
        if (_optGuid != null) {
            return false;
        }

        final java.util.UUID[] _arrGuid = value.getArrGuid();
        if (_arrGuid.length != 0) {
            return false;
        }

        final java.util.UUID[] _arrOptGuid = value.getArrOptGuid();
        if (_arrOptGuid.length != 0) {
            return false;
        }

        final java.util.UUID[] _optArrGuid = value.getOptArrGuid();
        if (_optArrGuid != null) {
            return false;
        }

        final java.util.UUID[] _optArrOptGuid = value.getOptArrOptGuid();
        if (_optArrOptGuid != null) {
            return false;
        }

        final java.util.List<java.util.UUID> _listGuid = value.getListGuid();
        if (_listGuid.size() != 0) {
            return false;
        }

        final java.util.List<java.util.UUID> _listOptGuid = value.getListOptGuid();
        if (_listOptGuid.size() != 0) {
            return false;
        }

        final java.util.List<java.util.UUID> _optListGuid = value.getOptListGuid();
        if (_optListGuid != null) {
            return false;
        }

        final java.util.List<java.util.UUID> _optListOptGuid = value.getOptListOptGuid();
        if (_optListOptGuid != null) {
            return false;
        }


        final java.util.Set<java.util.UUID> _setGuid = value.getSetGuid();
        if (_setGuid.size() != 0) {
            return false;
        }

        final java.util.Set<java.util.UUID> _setOptGuid = value.getSetOptGuid();
        if (_setOptGuid.size() != 0) {
            return false;
        }

        final java.util.Set<java.util.UUID> _optSetGuid = value.getOptSetGuid();
        if (_optSetGuid != null) {
            return false;
        }

        final java.util.Set<java.util.UUID> _optSetOptGuid = value.getOptSetOptGuid();
        if (_optSetOptGuid != null) {
            return false;
        }

        return true;
    }

    @Override
    public void toJson(
            final JsonWriter jsonWriter,
            final com.dslplatform.compiler.client.api.model.JSONTest.Guidlicious value) throws IOException {
        jsonWriter.writeOpenObject();
        boolean needsComma = false;

        final java.util.UUID _oneGuid = value.getOneGuid();
        if (!_UUIDJsonSerializer.isDefault(_oneGuid)) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"oneGuid\":");
            _UUIDJsonSerializer.toJson(jsonWriter, _oneGuid);
            needsComma = true;
        }

        final java.util.UUID _optGuid = value.getOptGuid();
        if (_optGuid != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optGuid\":");
            _UUIDJsonSerializer.toJson(jsonWriter, _optGuid);
            needsComma = true;
        }

        final java.util.UUID[] _arrGuid = value.getArrGuid();
        if (_arrGuid.length != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"arrGuid\":");
            jsonWriter.writeArray(_arrGuid, _UUIDJsonSerializer);
            needsComma = true;
        }

        final java.util.UUID[] _arrOptGuid = value.getArrOptGuid();
        if (_arrOptGuid.length != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"arrOptGuid\":");
            jsonWriter.writeArrayOpt(_arrOptGuid, _UUIDJsonSerializer);
            needsComma = true;
        }

        final java.util.UUID[] _optArrGuid = value.getOptArrGuid();
        if (_optArrGuid != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optArrGuid\":");
            jsonWriter.writeOptArray(_optArrGuid, _UUIDJsonSerializer);
            needsComma = true;
        }

        final java.util.UUID[] _optArrOptGuid = value.getOptArrOptGuid();
        if (_optArrOptGuid != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optArrOptGuid\":");
            jsonWriter.writeOptArrayOpt(_optArrOptGuid, _UUIDJsonSerializer);
            needsComma = true;
        }

        final java.util.List<java.util.UUID> _listGuid = value.getListGuid();
        if (_listGuid.size() != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"listGuid\":");
            jsonWriter.writeIterable(_listGuid, _UUIDJsonSerializer);
            needsComma = true;
        }

        final java.util.List<java.util.UUID> _listOptGuid = value.getListOptGuid();
        if (_listOptGuid.size() != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"listOptGuid\":");
            jsonWriter.writeIterableOpt(_listOptGuid, _UUIDJsonSerializer);
            needsComma = true;
        }

        final java.util.List<java.util.UUID> _optListGuid = value.getOptListGuid();
        if (_optListGuid != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optListGuid\":");
            jsonWriter.writeOptIterable(_optListGuid, _UUIDJsonSerializer);
            needsComma = true;
        }

        final java.util.List<java.util.UUID> _optListOptGuid = value.getOptListOptGuid();
        if (_optListOptGuid != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optListOptGuid\":");
            jsonWriter.writeOptIterableOpt(_optListOptGuid, _UUIDJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<java.util.UUID> _setGuid = value.getSetGuid();
        if (_setGuid.size() != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"setGuid\":");
            jsonWriter.writeIterable(_setGuid, _UUIDJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<java.util.UUID> _setOptGuid = value.getSetOptGuid();
        if (_setOptGuid.size() != 0) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"setOptGuid\":");
            jsonWriter.writeIterableOpt(_setOptGuid, _UUIDJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<java.util.UUID> _optSetGuid = value.getOptSetGuid();
        if (_optSetGuid != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optSetGuid\":");
            jsonWriter.writeOptIterable(_optSetGuid, _UUIDJsonSerializer);
            needsComma = true;
        }

        final java.util.Set<java.util.UUID> _optSetOptGuid = value.getOptSetOptGuid();
        if (_optSetOptGuid != null) {
            if (needsComma) jsonWriter.writeComma();
            jsonWriter.writeRaw("\"optSetOptGuid\":");
            jsonWriter.writeOptIterableOpt(_optSetOptGuid, _UUIDJsonSerializer);
            needsComma = true;
        }

        jsonWriter.writeCloseObject();
    }
}
