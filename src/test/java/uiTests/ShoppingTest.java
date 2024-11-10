package uiTests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.codeborne.selenide.Condition;
import java.time.Duration;

public class ShoppingTest extends UiTestBase {

    @Test
    public void testAddProductToCart() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();
        OrderPage orderPage = new OrderPage();

        System.out.println("Открываем домашнюю страницу...");
        open("https://www.demoblaze.com/");

        // Переход на страницу логина и выполнение логина
        System.out.println("Переходим на страницу логина...");
        homePage.clickLogin();
        System.out.println("Выполняем логин с данными пользователя...");
        loginPage.login("suraifokkusu", "1234");

        // Добавление товара в корзину
        System.out.println("Открываем страницу товара и добавляем его в корзину...");
        open("https://www.demoblaze.com/prod.html?idp_=1");
        $x("//a[@onclick='addToCart(1)']").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();

        // Переход в корзину
        System.out.println("Переходим в корзину...");
        open("https://www.demoblaze.com/cart.html");
        cartPage.waitForPageToLoad();

        // Проверка цены товара в корзине
        System.out.println("Проверяем цену товара в корзине...");
        String priceInCart = cartPage.getTotalPrice();
        assertEquals("360", priceInCart, "Цена товара в корзине не соответствует ожидаемой!");

        // Оформление заказа
        System.out.println("Оформляем заказ...");
        cartPage.clickPlaceOrder();
        orderPage.fillOrderForm("Иван", "Россия", "Москва", "1234567812345678", "12", "2025");
        orderPage.submitOrder();

        // Проверка цены в оформленном заказе
        System.out.println("Проверяем цену в оформленном заказе...");
        String orderPrice = orderPage.getOrderPrice();
        assertEquals("360", orderPrice, "Цена заказа не соответствует цене товара в корзине!");

        System.out.println("Тест успешно завершен: товар добавлен в корзину и заказ оформлен с правильной ценой.");
    }
}
