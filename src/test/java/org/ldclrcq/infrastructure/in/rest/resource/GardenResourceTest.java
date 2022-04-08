package org.ldclrcq.infrastructure.in.rest.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.ldclrcq.infrastructure.in.rest.dto.CreateGardenDTO;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GardenResourceTest {

    @Test
    void given_valid_dto_should_create_garden() {
        // ARRANGE
        final var createGardenDTO = new CreateGardenDTO("My beautiful garden", 2L, 3L);

        // ACT
        final var response = given()
                .body(createGardenDTO)
                .contentType(ContentType.JSON)
                .when().post("/gardens")
                .then();

        // ASSERT
        response
                .statusCode(Response.Status.CREATED.getStatusCode())
                .body("id", notNullValue())
                .body("name", equalTo("My beautiful garden"))
                .body("width", equalTo(2))
                .body("height", equalTo(3));
    }

    @Test
    void given_width_is_null_should_not_create_garden() {
        // ARRANGE
        final var createGardenDTO = new CreateGardenDTO("My beautiful garden", null, 3L);

        // ACT
        final var response = given()
                .body(createGardenDTO)
                .contentType(ContentType.JSON)
                .when().post("/gardens")
                .then();

        // ASSERT
        response
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    void given_width_is_0_should_not_create_garden() {
        // ARRANGE
        final var createGardenDTO = new CreateGardenDTO("My beautiful garden", 0L, 3L);

        // ACT
        final var response = given()
                .body(createGardenDTO)
                .contentType(ContentType.JSON)
                .when().post("/gardens")
                .then();

        // ASSERT
        response
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    void given_height_is_null_should_not_create_garden() {
        // ARRANGE
        final var createGardenDTO = new CreateGardenDTO("My beautiful garden", 2L, null);

        // ACT
        final var response = given()
                .body(createGardenDTO)
                .contentType(ContentType.JSON)
                .when().post("/gardens")
                .then();

        // ASSERT
        response
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    void given_height_is_0_should_not_create_garden() {
        // ARRANGE
        final var createGardenDTO = new CreateGardenDTO("My beautiful garden", 2L, 0L);

        // ACT
        final var response = given()
                .body(createGardenDTO)
                .contentType(ContentType.JSON)
                .when().post("/gardens")
                .then();

        // ASSERT
        response
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }
}