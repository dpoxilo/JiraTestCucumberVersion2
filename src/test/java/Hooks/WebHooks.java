package Hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;

public class WebHooks {
    @Before
    public static void before() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false));
    }

    public static void setUp() {
        Configuration.startMaximized = true;
    }

    @After
    public void webClose() {
        WebDriverRunner.closeWebDriver();
    }
}
