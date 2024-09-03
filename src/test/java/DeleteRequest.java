
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteRequest {

    @Test
    public void testDeleteRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .queryParam("key", "value") 
                .when()
                .delete("/delete") 
                .then()
                .extract()
                .response();

        assertEquals(200, response.getStatusCode(), "Ожидаемый код состояния 200");

        assertEquals("value", response.jsonPath().getString("args.key"), "Key параметра не соответствует");

    }
}
