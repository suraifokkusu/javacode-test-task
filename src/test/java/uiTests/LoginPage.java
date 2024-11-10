package uiTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private SelenideElement usernameField = $x("//*[@id='loginusername']");
    private SelenideElement passwordField = $x("//*[@id='loginpassword']");
    private SelenideElement loginButton = $x("//*[@onclick='logIn()']");

    public void login(String username, String password) {
        System.out.println("Вводим логин и пароль...");
        usernameField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(username);
        passwordField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(password);
        loginButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }
}
