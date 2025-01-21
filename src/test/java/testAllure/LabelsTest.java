package testAllure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    @Feature("Issue in repository")
    @Story("Creating of an issue in repository")
    @Owner("aldm")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Github", url = "https://testing.github.com")
    @DisplayName("Issue creation for authorized user")
    public void testStaticLabels(){

    }
    @Test
    public void  testDynamicLabels(){
        Allure.getLifecycle().updateTestCase(
                t -> t.setName ("Issue creation for authorized user"));
        Allure.feature("Issue in repository");
        Allure.story("Creating of an issue in repository");
        Allure.label("owner","aldm");
        Allure.label("severity",SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");


    }
}
