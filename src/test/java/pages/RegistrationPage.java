package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;
import pages.components.RegistrationModalResults;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    Calendar calendar = new Calendar();
    RegistrationModalResults registrationModalResults = new RegistrationModalResults();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            userPhoneNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            uploadFile = $("#uploadPicture"),
            submitButton = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        sleep(5000);
        $(".practice-form-wrapper").shouldBe(visible);
        Selenide.executeJavaScript("$('#RightSide_Advertisement').remove()");
        return this;
    }

    public RegistrationPage fillFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage fillLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage fillEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage fillCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage fillPhoneNumber(String value) {
        userPhoneNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDate(String Month, String Year, String Day) {
        $("#dateOfBirthInput").click();
        calendar.setDate(Month, Year, Day);
        return this;
    }

    public RegistrationPage setGender(String value) {
        if (value.equals("Male")) {
            $("#gender-radio-1").parent().click();
        } else if (value.equals("Female")) {
            $("#gender-radio-2").parent().click();
        } else if (value.equals("Other")) {
            $("#gender-radio-3").parent().click();
        }
        return this;
    }
    public RegistrationPage fillSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
         if (value.equals("Sports")) {
            $("#hobbies-checkbox-1").parent().click();
        } else if (value.equals("Reading")) {
            $("#hobbies-checkbox-2").parent().click();
        } else if (value.equals("Music")) {
            $("#hobbies-checkbox-3").parent().click();
        }
        return this;
    }
    public RegistrationPage uploadPicture(String value) {
        uploadFile.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage fillState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPage fillCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }
    public RegistrationPage registrationPageVerifyModalAppears() {
        registrationModalResults.regitrationPageModalAppears();
        return this;
    }
    public RegistrationPage verifyModalResults(String Label, String Value){
        registrationModalResults.verifyResults(Label,Value);
        return this;
    }



}
