
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatchRequest {

    @Test
    public void testPatchRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        String jsonBody = "{\"key1\":\"patchedValue1\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .patch("/patch")
                .then()
                .extract()
                .response();

        assertEquals(200, response.getStatusCode(), "Ожидаемый код состояния 200");

        assertEquals("patchedValue1", response.jsonPath().getString("json.key1"), "Поле key1 не соответствует");

    }
}
