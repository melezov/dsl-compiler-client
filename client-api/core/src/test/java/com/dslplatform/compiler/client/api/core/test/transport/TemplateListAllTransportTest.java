package com.dslplatform.compiler.client.api.core.test.transport;

import com.dslplatform.compiler.client.api.core.HttpRequest;
import com.dslplatform.compiler.client.api.core.HttpResponse;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class TemplateListAllTransportTest extends HttpTransportImplTest {

    @Test
    public void testTemplateListAllRequest() throws IOException {
        final HttpRequest templateListAllRequest; {
            final String token = projectToken(validUser, validPassword, validId);
            templateListAllRequest = httpRequestBuilder.templateListAll(token, UUID.fromString(validId));
        }

        final HttpResponse response = httpTransport.sendRequest(templateListAllRequest);
        assertEquals(200, response.code);
        logger.info("response: {}", new String(response.body));
        assertEquals(Arrays.asList("application/json"), response.headers.get("Content-Type"));
    }
}