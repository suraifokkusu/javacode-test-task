package uiTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {

    private SelenideElement nameField = $x("//*[@id='name']");
    private SelenideElement countryField = $x("//*[@id='country']");
    private SelenideElement cityField = $x("//*[@id='city']");
    private SelenideElement cardField = $x("//*[@id='card']");
    private SelenideElement monthField = $x("//*[@id='month']");
    private SelenideElement yearField = $x("//*[@id='year']");
    private SelenideElement purchaseButton = $x("//*[@onclick='purchaseOrder()']");
    private SelenideElement orderPrice = $x("//*[@id='totalp']");

    public void fillOrderForm(String name, String country, String city, String card, String month, String year) {
        System.out.println("Заполняем форму заказа...");
        nameField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(name);
        countryField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(country);
        cityField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(city);
        cardField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(card);
        monthField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(month);
        yearField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(year);
    }

    public void submitOrder() {
        System.out.println("Отправляем заказ...");
        purchaseButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    public String getOrderPrice() {
        System.out.println("Получаем цену заказа...");
        return orderPrice.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
    }
}
