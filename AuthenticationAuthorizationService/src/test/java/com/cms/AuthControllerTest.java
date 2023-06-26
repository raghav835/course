package com.cms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthControllerTest {

    @Test
    public void test202RestApiCallForTokenGeneration() {
        // Setup
        RestAssured.baseURI = "http://localhost:8080/app";

        // Request
        Response response = RestAssured.post("/sign");

        // Assert
        Assertions.assertEquals(202, response.statusCode());
        Assertions.assertEquals("Bearer token", response.header("Authorization"));
    }

    @Test
    public void test203RestApiCallForValidatingToken() {
        // Setup
        RestAssured.baseURI = "http://localhost:8080/app";

        // Request
        Response response = RestAssured.get("/validateToken/Bearer token");

        // Assert
        Assertions.assertEquals(203, response.statusCode());
        Assertions.assertEquals("Token is valid", response.body().asString());
    }
}
