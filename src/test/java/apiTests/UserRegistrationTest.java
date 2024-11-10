package apiTests;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserRegistrationTest extends ApiTestBase {

    @Test
    public void successfulRegistration() {
        // Тело запроса с корректными данными для успешной регистрации
        String requestBody = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }";
        System.out.println("Отправляем запрос на успешную регистрацию пользователя...");

        // Отправляем POST-запрос на регистрацию пользователя
        given()
                .spec(requestSpec) // Используем общую спецификацию запроса для упрощения кода
                .body(requestBody) // Передаем тело запроса
                .when()
                .post("/api/register") // Указываем конечную точку для регистрации
                .then()
                .spec(successfulResponseSpec) // Проверяем успешный статус-код с помощью спецификации
                .body("id", notNullValue()) // Убедимся, что поле "id" не пустое
                .body("token", notNullValue()) // Убедимся, что поле "token" не пустое
                .time(lessThan(2000L)); // Проверка, что время ответа меньше 2 секунд

        // Логируем успешное завершение регистрации
        System.out.println("Пользователь успешно зарегистрирован.");
    }

    @Test
    public void registrationWithoutPassword() {
        // Тело запроса без пароля для проверки обработки ошибки
        String requestBody = "{ \"email\": \"eve.holt@reqres.in\" }";
        System.out.println("Отправляем запрос на регистрацию без пароля...");

        // Отправляем POST-запрос на регистрацию без пароля
        given()
                .spec(requestSpec) // Используем общую спецификацию запроса
                .body(requestBody) // Передаем тело запроса
                .when()
                .post("/api/register") // Указываем конечную точку для регистрации
                .then()
                .spec(errorResponseSpec) // Проверяем статус-код ошибки с помощью спецификации
                .body("error", equalTo("Missing password")) // Проверяем, что сообщение об ошибке соответствует ожиданиям
                .time(lessThan(2000L)); // Проверка, что время ответа меньше 2 секунд

        // Логируем успешное завершение проверки ошибки
        System.out.println("Проверка завершена: пароль отсутствует.");
    }
}
