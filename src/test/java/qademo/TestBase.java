package qademo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;
import qademo.helpers.Attach;

import java.util.Map;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = System.getProperty("base_url","https://demoqa.com");
//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browser = "chrome";
        Configuration.browser = System.getProperty("browser","chrome");
//        Configuration.browserVersion = "100.0";
        Configuration.browserVersion = System.getProperty("version","100.0");
        Configuration.pageLoadTimeout = 90000;
        Configuration.browserSize = System.getProperty("size","1920x1080");
//        Configuration.browserSize = "1920x1080";
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.remote = System.getProperty("remote","https://user1:1234@selenoid.autotests.cloud/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
            "enableVNC", true,
            "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

    }
    @BeforeEach
            void addListener(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
