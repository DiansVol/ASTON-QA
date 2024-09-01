
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostFormData {

    @Test
    public void testPostFormData() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .param("key1", "value1")
                .param("key2", "value2")
                .when()
                .post("/post")
                .then()
                .extract()
                .response();

        assertEquals(200, response.getStatusCode(), "Ожидаемый код состояния 200");

        assertEquals("value1", response.jsonPath().getString("form.key1"), "Поле key1 не соответствует");
        assertEquals("value2", response.jsonPath().getString("form.key2"), "Поле key2 не соответствует");
    }
}
