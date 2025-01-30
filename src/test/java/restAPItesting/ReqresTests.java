package restAPItesting;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ReqresTests {

    @Test
    public void createUser(){
        String body = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

       given()
               .log().uri()
               .body(body)
               .when()
               .post("https://reqres.in/api/users")
               .then()
               .log().status()
               .log().body()
               .statusCode(201)
               .body("id", notNullValue());
    }

    @Test
    public void getResource(){

        given()
                .log().uri()
                .when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("support.text", is("Tired of writing endless social media content? Let Content Caddy generate it for you."));
    }
}
