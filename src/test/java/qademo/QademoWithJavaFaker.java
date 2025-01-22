package qademo;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TestData;

import java.util.Locale;

import static utils.RandomUtils.randomEmail;
import static utils.RandomUtils.randomString;

@Tag("Simple")
public class QademoWithJavaFaker extends TestBase{

    @Test
    void testRegistrationPage() {
//        SelenideLogger.addListener("allure", new AllureSelenide());
        TestData testData = new TestData();
//        Faker faker = new Faker();
//        Faker faker = new Faker(new Locale("ru"));
//        String FirstName = faker.name().firstName();
//        String LastName = faker.name().lastName();
//        String FullName = FirstName + " " + LastName;
//        String Email = faker.internet().emailAddress();
//        String PhoneNumber = faker.phoneNumber().subscriberNumber(10);
//        String CurrentAddress = faker.address().fullAddress();
//        String Gender = "Male";
//        String MonthOfBirth = "August";
//        String YearOfBirth = "1991";
//        String DayOfBirth = "16";
//        String BirthDay = DayOfBirth + " " + MonthOfBirth + ',' + YearOfBirth;
//        String Subject = "English";
//        String Hobbies = "Music";
//        String Picture = "img/1.png";
//        String State = "NCR";
//        String City = "Delhi";
//        String State_City = State + " " + City;

        registrationPage.openPage()
                .fillFirstName(testData.FirstName)
                .fillLastName(testData.LastName)
                .setGender(testData.Email)
                .fillPhoneNumber(testData.PhoneNumber)
                .fillEmail(testData.Email)
                .fillCurrentAddress(testData.CurrentAddress)
                .setGender(testData.Gender)
                .setBirthDate(testData.MonthOfBirth,testData. YearOfBirth,testData. DayOfBirth)
                .fillSubject(testData.Subject)
                .setHobbies(testData.Hobbies)
                .uploadPicture(testData.Picture)
                .fillState(testData.State)
                .fillCity(testData.City)
                .submitForm();
        registrationPage.registrationPageVerifyModalAppears()
                .verifyModalResults("Student Name",testData.FullName)
                .verifyModalResults("Student Email",testData.Email )
                .verifyModalResults("Gender",testData.Gender )
                .verifyModalResults("Mobile",testData.PhoneNumber )
                .verifyModalResults("Date of Birth",testData.BirthDay)
                .verifyModalResults("Subjects",testData.Subject )
                .verifyModalResults("Hobbies",testData.Hobbies )
                .verifyModalResults("Address",testData.CurrentAddress)
                .verifyModalResults("State and City",testData.State_City );
    }
}
