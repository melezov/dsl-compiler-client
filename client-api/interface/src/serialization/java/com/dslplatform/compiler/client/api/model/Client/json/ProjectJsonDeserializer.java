//package com.dslplatform.compiler.client.api.model.Client.json;
//
//import io.jvm.json.JsonReader;
//
//import java.io.IOException;
//import java.util.UUID;
//
//import org.joda.time.DateTime;
//import org.slf4j.Logger;
//
//import com.dslplatform.client.serialization.json.JsonDeserializer;
//import com.dslplatform.compiler.client.api.model.Client.Project;
//import com.dslplatform.patterns.ServiceLocator;
//
//public class ProjectJsonDeserializer implements JsonDeserializer<Project> {
//    private final ServiceLocator locator;
//    private final Logger logger;
//
//    public ProjectJsonDeserializer(
//            final ServiceLocator locator,
//            final Logger logger) {
//        this.locator = locator;
//        this.logger = logger;
//    }
//
//    public Project fromJson(final JsonReader jsonReader) throws IOException {
//        if (jsonReader.read() == '{') {
//
//          boolean needComma = false;
//
//          String URI = null;
//          UUID ID = UUID.randomUUID();
//          String Nick = null;
//          DateTime CreatedAt = DateTime.now();
//
//          while (jsonReader.next() != '}') {
//              if (needComma) jsonReader.assertLast(',');
//
//              final String property = jsonReader.readString();
//              jsonReader.assertNext(':');
//
//              if (property.equals("URI")) {
//                  URI = jsonReader.readString();
//                  needComma = true;
//                  continue;
//              }
//
//              if (property.equals("ID")) {
//                  ID = UUID.fromString(jsonReader.readString());
//                  needComma = true;
//                  continue;
//              }
//
//              if (property.equals("Nick")) {
//                  Nick = jsonReader.readString();
//                  needComma = true;
//                  continue;
//              }
//
//              if (property.equals("CreatedAt")) {
//                  CreatedAt = new DateTime(jsonReader.readString());
//                  needComma = true;
//                  continue;
//              }
//          }
//
//          return Project.buildInternal(
//                  locator,
//                  URI,
//                  ID,
//                  Nick,
//                  CreatedAt);
//        }
//
//        return jsonReader.readNull();
//    }
//}
