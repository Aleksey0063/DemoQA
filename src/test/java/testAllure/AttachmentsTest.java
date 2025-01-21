package testAllure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AttachmentsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "95";
    @Test
    public void testLambdaAttachments (){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
                });
        attachment("Source", webdriver().driver().source());
        step("Ищем репозиторий " + REPOSITORY, () ->{
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();

        });
        step("Кликаем по ссылке репозитория", () ->{
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем табу Issues", () ->{
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером "+ ISSUE, () ->{
            $(withText(ISSUE)).should(exist);
        });

    }
    @Test
    public void testAnnotationAttachments () {

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.takeScreenshot();
    }
}
