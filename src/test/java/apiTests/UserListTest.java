package apiTests;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserListTest extends ApiTestBase {

    @Test
    public void validateEmailAddresses() {
        // Выводим информацию в консоль для отслеживания шагов выполнения теста
        System.out.println("Запрашиваем список пользователей на второй странице...");

        // Отправляем GET-запрос на получение списка пользователей на второй странице
        given()
                .spec(requestSpec) // Используем общую спецификацию запроса, чтобы избежать дублирования кода
                .when()
                .get("/api/users?page=2") // Указываем путь для запроса
                .then()
                .spec(successfulResponseSpec) // Проверяем успешный статус-код с помощью заранее заданной спецификации
                .body("data.email", everyItem(endsWith("@reqres.in"))) // Проверяем, что все email адреса оканчиваются на "@reqres.in"
                .time(lessThan(2000L)); // Проверяем, что время ответа меньше 2 секунд

        // Логируем успешное завершение проверки email адресов
        System.out.println("Проверка email адресов завершена успешно.");
    }
}
