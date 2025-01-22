package tests;
import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1280x672";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://www.tbank.ru";
    }
    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterEach
    void closeWebDriver() {
        Selenide.closeWebDriver();
    }
}