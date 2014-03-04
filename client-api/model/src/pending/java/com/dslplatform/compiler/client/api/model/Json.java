package com.dslplatform.compiler.client.api.model;

import com.dslplatform.client.serialization.json.JsonMapper;
import com.dslplatform.patterns.ServiceLocator;

public class Json extends JsonMapper {
    public Json(final ServiceLocator serviceLocator) {
        super(serviceLocator);

        registerSerializer(com.dslplatform.compiler.client.api.model.Client.json.ProjectJsonSerializer.class);

        registerDeserializer(com.dslplatform.compiler.client.api.model.Client.json.ProjectJsonDeserializer.class);
    }
}
