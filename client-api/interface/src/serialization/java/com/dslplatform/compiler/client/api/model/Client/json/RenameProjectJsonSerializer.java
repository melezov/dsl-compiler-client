//package com.dslplatform.compiler.client.api.model.Client.json;
//
//import io.jvm.json.JsonWriter;
//
//import java.io.IOException;
//
//import com.dslplatform.client.serialization.json.JsonSerializer;
//import com.dslplatform.compiler.client.api.model.Client.RenameProject;
//
//public enum RenameProjectJsonSerializer implements JsonSerializer<RenameProject> {
//    INSTANCE;
//
//    @Override
//    public void toJson(final JsonWriter jsonWriter, final RenameProject value) throws IOException {
//        boolean needsComma = false;
//        jsonWriter.writeOpenObject();
//
//        final String _URI = value.getURI();
//        if (_URI != null) {
//            if (needsComma) jsonWriter.writeComma();
//            jsonWriter.writeRaw("\"URI\":");
//            jsonWriter.writeString(_URI);
//            needsComma = true;
//        }
//
//        final String _OldName = value.getOldName();
//        if (!_OldName.isEmpty()) {
//            if (needsComma) jsonWriter.writeComma();
//            jsonWriter.writeRaw("\"OldName\":");
//            jsonWriter.writeString(_OldName);
//            needsComma = true;
//        }
//
//        final String _NewName = value.getNewName();
//        if (!_NewName.isEmpty()) {
//            if (needsComma) jsonWriter.writeComma();
//            jsonWriter.writeRaw("\"NewName\":");
//            jsonWriter.writeString(_NewName);
//            needsComma = true;
//        }
//
//        jsonWriter.writeCloseObject();
//    }
//}
