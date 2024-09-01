
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PutRequest {

    @Test
    public void testPutRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        String jsonBody = "{\"key1\":\"updatedValue1\", \"key2\":\"updatedValue2\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .put("/put")
                .then()
                .extract()
                .response();

        assertEquals(200, response.getStatusCode(), "Ожидаемый код состояния 200");

        assertEquals("updatedValue1", response.jsonPath().getString("json.key1"), "Поле key1 не соответствует");
        assertEquals("updatedValue2", response.jsonPath().getString("json.key2"), "Поле key2 не соответствует");
    }
}
