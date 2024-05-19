package com.jovisco;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

@QuarkusIntegrationTest
class BookResourceIT extends BookResourceTest {

    @Override
    void testGetById() {
        given()
            .headers(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
            .pathParam("id", 1)
        .when()
            .get("/api/books/{id}")
        .then()
            .statusCode(200)
            .body("title", containsStringIgnoringCase("Understanding"))
            .body("author", containsStringIgnoringCase("Antonio"))
            .body("yearOfPublication", is(2020))
            .body("genre", is("Poetry"));
    }
    // Execute the same tests but in packaged mode.
}
