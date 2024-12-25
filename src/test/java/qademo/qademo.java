package qademo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class qademo {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadTimeout = 90000;
//        Configuration.browserSize = "1920x1080";

    }
    @Test
    void testFields(){
       open("/automation-practice-form");
       sleep(5000);
       $(".practice-form-wrapper").shouldBe(visible);

       //close banner
        Selenide.executeJavaScript("$('#RightSide_Advertisement').remove()");

       //file form
       $("#firstName").setValue("Aleksei");
       $("#lastName").setValue("Dmitriev");
       $("#userEmail").setValue("test@test.com");
       $("#currentAddress").setValue("Samara");
       $("#userNumber").setValue("8911111111");

       $("#gender-radio-1").parent().click();
       $("#dateOfBirthInput").click();
       $(".react-datepicker__month-select").selectOption("August");
       $(".react-datepicker__year-select").selectOption("1991");
       $(".react-datepicker__day--016").click();
       $("#subjectsInput").setValue("English").pressEnter();
       $("#hobbies-checkbox-1").parent().click();
//     $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
       $("#uploadPicture").uploadFromClasspath("img/1.png");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        //assertions
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Aleksei"), text("Dmitriev"));


    sleep(10000);
    }
}
