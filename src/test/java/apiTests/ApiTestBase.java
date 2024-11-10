package apiTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiTestBase {
    // RequestSpecification для настройки общих параметров запроса
    protected static RequestSpecification requestSpec;

    // ResponseSpecification для успешных ответов (статус-код 200)
    protected static ResponseSpecification successfulResponseSpec;

    // ResponseSpecification для ошибок (статус-код 400)
    protected static ResponseSpecification errorResponseSpec;

    static {
        // Устанавливаем базовый URI и добавляем заголовок Content-Type
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .addHeader("Content-Type", "application/json") // Общий заголовок для всех запросов
                .build();

        // Ожидаем успешный ответ с кодом 200
        successfulResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        // Ожидаем ошибочный ответ с кодом 400
        errorResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }
}
