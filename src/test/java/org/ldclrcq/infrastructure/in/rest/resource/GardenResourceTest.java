package org.ldclrcq.infrastructure.in.rest.resource;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.keycloak.client.KeycloakTestClient;
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
    KeycloakTestClient keycloakClient = new KeycloakTestClient();

    @Test
    @TestTransaction
    void given_valid_dto_should_create_garden() {
        // ARRANGE
        final var accessToken = keycloakClient.getAccessToken("alice");
        final var createGardenDTO = new CreateGardenDTO("My beautiful garden", 2L, 3L);

        // ACT
        final var response = given()
                .auth().oauth2(accessToken)
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
    @TestTransaction
    void given_width_is_null_should_not_create_garden() {
        // ARRANGE
        final var accessToken = keycloakClient.getAccessToken("alice");
        final var createGardenDTO = new CreateGardenDTO("My beautiful garden", null, 3L);

        // ACT
        final var response = given()
                .auth().oauth2(accessToken)
                .body(createGardenDTO)
                .contentType(ContentType.JSON)
                .when().post("/gardens")
                .then();

        // ASSERT
        response
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    @TestTransaction
    void given_width_is_0_should_not_create_garden() {
        // ARRANGE
        final var accessToken = keycloakClient.getAccessToken("alice");
        final var createGardenDTO = new CreateGardenDTO("My beautiful garden", 0L, 3L);

        // ACT
        final var response = given()
                .auth().oauth2(accessToken)
                .body(createGardenDTO)
                .contentType(ContentType.JSON)
                .when().post("/gardens")
                .then();

        // ASSERT
        response
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    @TestTransaction
    void given_height_is_null_should_not_create_garden() {
        // ARRANGE
        final var accessToken = keycloakClient.getAccessToken("alice");
        final var createGardenDTO = new CreateGardenDTO("My beautiful garden", 2L, null);

        // ACT
        final var response = given()
                .auth().oauth2(accessToken)
                .body(createGardenDTO)
                .contentType(ContentType.JSON)
                .when().post("/gardens")
                .then();

        // ASSERT
        response
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    @TestTransaction
    void given_height_is_0_should_not_create_garden() {
        // ARRANGE
        final var accessToken = keycloakClient.getAccessToken("alice");
        final var createGardenDTO = new CreateGardenDTO("My beautiful garden", 2L, 0L);

        // ACT
        final var response = given()
                .auth().oauth2(accessToken)
                .body(createGardenDTO)
                .contentType(ContentType.JSON)
                .when().post("/gardens")
                .then();

        // ASSERT
        response
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    @TestTransaction
    void given_created_garden_should_return_garden() {
        // ARRANGE
        final var accessToken = keycloakClient.getAccessToken("alice");
        final var createGardenDTO = new CreateGardenDTO("My beautiful garden", 2L, 2L);
        given()
                .auth().oauth2(accessToken)
                .body(createGardenDTO)
                .contentType(ContentType.JSON)
                .when().post("/gardens")
                .then().statusCode(201);

        // ACT
        final var response = given()
                .auth().oauth2(accessToken)
                .when().get("/gardens")
                .then();

        // ASSERT
        response
                .statusCode(200);
    }

    @Test
    @TestTransaction
    void given_unknown_id_should_return_error() {
        // ARRANGE
        final var accessToken = keycloakClient.getAccessToken("alice");
        final var id = 1L;

        // ACT
        final var response = given()
                .auth().oauth2(accessToken)
                .pathParam("gardenId", id)
                .when().get("/gardens/{gardenId}")
                .then();

        // ASSERT
        response
                .statusCode(404);
    }
}