package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

   @Step("открыть страницу")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        sleep(5000);
        $(".practice-form-wrapper").shouldBe(visible);
        Selenide.executeJavaScript("$('#RightSide_Advertisement').remove()");
        return this;
    }
    @Step("заполнить имя")
    public RegistrationPage fillFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("заполнить фамилию")
    public RegistrationPage fillLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("заполнить электронную почту")
    public RegistrationPage fillEmail(String value) {
        emailInput.setValue(value);
        return this;
    }
    @Step("заполнить адрес")
    public RegistrationPage fillCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    @Step("заполнить номер телефона")
    public RegistrationPage fillPhoneNumber(String value) {
        userPhoneNumberInput.setValue(value);
        return this;
    }
    @Step("заполнить дату рождения")
    public RegistrationPage setBirthDate(String Month, String Year, String Day) {
        $("#dateOfBirthInput").click();
        calendar.setDate(Month, Year, Day);
        return this;
    }
    @Step("указать пол")
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
    @Step("указать предмет")
    public RegistrationPage fillSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }
    @Step("указать хобби")
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
    @Step("загрузить картинку")
    public RegistrationPage uploadPicture(String value) {
        uploadFile.uploadFromClasspath(value);
        return this;
    }
    @Step("заполнить штат")
    public RegistrationPage fillState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
    @Step("заполнить город")
    public RegistrationPage fillCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
    @Step("отправить форму")
    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }
    @Step("проверить модальное окно")
    public RegistrationPage registrationPageVerifyModalAppears() {
        registrationModalResults.regitrationPageModalAppears();
        return this;
    }
    @Step("проверить результаты")
    public RegistrationPage verifyModalResults(String Label, String Value){
        registrationModalResults.verifyResults(Label,Value);
        return this;
    }



}
