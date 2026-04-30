package com.api.testing.request;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiRequestManager {

    private final RequestSpecification requestSpecification;

    public ApiRequestManager(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public Response post(String endpoint, String body) {
        return given()
                .spec(requestSpecification)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response get(String endpoint) {
        return given()
                .spec(requestSpecification)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
}
