package com.dslplatform.compiler.client.api.model.JSONTest.repositories;

import com.dslplatform.patterns.*;
import com.dslplatform.client.*;

public class RootlyTypedRepository
        extends
        ClientPersistableRepository<com.dslplatform.compiler.client.api.model.JSONTest.RootlyTyped> {
    public RootlyTypedRepository(
            final ServiceLocator locator) {
        super(
                com.dslplatform.compiler.client.api.model.JSONTest.RootlyTyped.class,
                locator);
    }
}
