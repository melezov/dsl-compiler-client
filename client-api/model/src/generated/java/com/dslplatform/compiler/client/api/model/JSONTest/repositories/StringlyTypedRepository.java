package com.dslplatform.compiler.client.api.model.JSONTest.repositories;

import com.dslplatform.patterns.*;
import com.dslplatform.client.*;

public class StringlyTypedRepository
        extends
        ClientPersistableRepository<com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped> {
    public StringlyTypedRepository(
            final ServiceLocator locator) {
        super(
                com.dslplatform.compiler.client.api.model.JSONTest.StringlyTyped.class,
                locator);
    }
}
