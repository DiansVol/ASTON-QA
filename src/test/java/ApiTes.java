import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTes {

    @Test
    public void testGetMethod() {

        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .when()
                .get("/get")  // Здесь указываем конечную точку
                .then()
                .extract()
                .response();

        assertEquals(200, response.getStatusCode(), "Ожидаемый код состояния 200");

        assertEquals(false, response.getBody().asString().isEmpty(), "Тело ответа не должно быть пустым");

    }
}
