import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class POST_Raw_Text {

    @Test
    public void testPostRawText() {
        RestAssured.baseURI = "https://postman-echo.com";

        String jsonBody = "{\"key1\":\"value1\", \"key2\":\"value2\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post("/post")
                .then()
                .extract()
                .response();

        assertEquals(200, response.getStatusCode(), "Ожидаемый код состояния 200");

        assertEquals("value1", response.jsonPath().getString("json.key1"), "Поле key1 не соответствует");
        assertEquals("value2", response.jsonPath().getString("json.key2"), "Поле key2 не соответствует");
    }
}
