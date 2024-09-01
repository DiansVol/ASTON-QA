
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteRequest {

    @Test
    public void testDeleteRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        // Если нужно передать параметры, вы можете использовать queryParam или pathParam
        // Пример передачи параметра, если это необходимо
        Response response = given()
                .queryParam("key", "value")  // Пример параметра для DELETE
                .when()
                .delete("/delete")  // Конечная точка
                .then()
                .extract()
                .response();

        // Проверка статуса ответа
        assertEquals(200, response.getStatusCode(), "Ожидаемый код состояния 200");

        // Проверка тела ответа, если нужно
        assertEquals("value", response.jsonPath().getString("args.key"), "Key параметра не соответствует");
        // В зависимости от API, вы можете проверить другие поля в ответе, если присутствуют
    }
}
