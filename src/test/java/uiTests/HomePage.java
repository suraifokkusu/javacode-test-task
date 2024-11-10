package uiTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    private SelenideElement loginLink = $x("//*[@id='login2']");

    public void openPage() {
        loginLink.shouldBe(Condition.visible, Duration.ofSeconds(10)); // Ожидание видимости
    }

    public void clickLogin() {
        System.out.println("Кликаем на ссылку 'Login'...");
        loginLink.click();
    }
}
