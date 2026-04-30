package com.api.testing.validation;

import io.restassured.response.Response;
import org.testng.Assert;

public final class ResponseValidator {

    private ResponseValidator() {
        // Utility class
    }

    public static void assertStatusCode(Response response, int expectedStatus) {
        Assert.assertEquals(response.getStatusCode(), expectedStatus,
                "Expected status code " + expectedStatus + " but received " + response.getStatusCode());
    }

    public static void assertBodyContains(Response response, String field, String expectedValue) {
        Assert.assertEquals(response.jsonPath().getString(field), expectedValue,
                "Expected response field '" + field + "' to contain value '" + expectedValue + "'.");
    }
}
