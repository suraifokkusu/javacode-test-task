package uiTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class UiTestBase {

    @BeforeAll
    public static void setup() {
        // Настройка Selenide
        Configuration.browser = "chrome";
        Configuration.browserSize = "1200x800"; // Открываем браузер в максимальном размере
        Configuration.baseUrl = "https://www.demoblaze.com";
        Configuration.headless = false; // Открываем браузер в видимом режиме
        Configuration.timeout = 10000; // Устанавливаем тайм-аут ожидания элементов
        Configuration.holdBrowserOpen = false; // Не держим браузер открытым после тестов

        // Устанавливаем путь к WebDriver, если он не прописан в системных переменных
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        System.out.println("Настройки Selenide применены: браузер Chrome, окно в полный размер, тайм-аут 10 секунд.");
    }

    @AfterEach
    public void tearDown() {
        // Закрываем браузер после каждого теста
        closeWebDriver();
    }
}
