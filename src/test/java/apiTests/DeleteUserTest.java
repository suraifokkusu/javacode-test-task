package apiTests;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class DeleteUserTest extends ApiTestBase {

    @Test
    public void deleteUser() {
        // ID пользователя, которого мы собираемся удалить
        int userId = 2;
        System.out.println("Отправляем запрос на удаление пользователя с ID: " + userId);

        // Отправляем DELETE-запрос и проверяем результаты
        given()
                .spec(requestSpec) // Используем общую спецификацию запроса
                .when()
                .delete("/api/users/" + userId) // Формируем путь с ID пользователя
                .then()
                .statusCode(204) // Проверяем, что статус-код ответа 204 (Удалено)
                .time(lessThan(2000L)); // Проверяем, что время ответа меньше 2 секунд

        System.out.println("Пользователь успешно удален, проверка завершена.");
    }
}
