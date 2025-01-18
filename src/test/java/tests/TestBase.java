package tests;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;



public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1000x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://www.tbank.ru";
    }
}