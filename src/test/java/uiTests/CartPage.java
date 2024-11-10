package uiTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    private SelenideElement totalPrice = $x("//*[@id='totalp']");
    private SelenideElement placeOrderButton = $x("//*[text()='Place Order']");

    public void waitForPageToLoad() {
        System.out.println("Ждем загрузки страницы корзины...");
        totalPrice.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public String getTotalPrice() {
        System.out.println("Получаем общую цену товаров в корзине...");
        return totalPrice.getText();
    }

    public void clickPlaceOrder() {
        System.out.println("Кликаем на кнопку 'Place Order'...");
        placeOrderButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }
}
