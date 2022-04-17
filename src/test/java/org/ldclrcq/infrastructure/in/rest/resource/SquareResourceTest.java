package org.ldclrcq.infrastructure.in.rest.resource;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.keycloak.client.KeycloakTestClient;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.ldclrcq.domain.SquareType;
import org.ldclrcq.infrastructure.in.rest.dto.CreateGardenDTO;
import org.ldclrcq.infrastructure.in.rest.dto.GardenDTO;

import static io.restassured.RestAssured.given;

@QuarkusTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SquareResourceTest {
    KeycloakTestClient keycloakClient = new KeycloakTestClient();

    @Test
    @TestTransaction
    void given_created_garden_should_return_garden() {
        // ARRANGE
        final var accessToken = keycloakClient.getAccessToken("alice");
        final var createGardenDTO = new CreateGardenDTO("My beautiful garden", 2L, 2L);
        final var createdGarden = given()
                .auth().oauth2(accessToken)
                .body(createGardenDTO)
                .contentType(ContentType.JSON)
                .when().post("/gardens")
                .then().statusCode(201)
                .extract().as(GardenDTO.class);
        final var someSquareId = createdGarden.rows().get(0).squares().get(0).id();

        // ACT
        final var response = given()
                .contentType(ContentType.JSON)
                .contentType(ContentType.JSON)
                .auth().oauth2(accessToken)
                .pathParam("squareId", someSquareId)
                .when().post("/squares/{squareId}/cultivate")
                .then();

        // ASSERT
        response
                .statusCode(200)
                .body("id", Matchers.equalTo(someSquareId.intValue()))
                .body("type", Matchers.equalTo(SquareType.CULTIVATED.toString()));
    }
}