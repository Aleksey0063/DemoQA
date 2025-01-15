package qademo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class QaDemowithAnnotations extends TestBase {
@CsvSource({
        "Aleksei,Ivanov,test@test.com,8923483745,samara,Male,August,1991,16",
        "Ivan,Semenov,new@test.com,8993483745,Moscow,Male,November,1993,18"
})
    @DisplayName("Параметризованный тест с использованием csvSource")
    @ParameterizedTest
//    @Disabled
    @Tags({@Tag("Blocker"),@Tag("UI")})
    void testRegistrationPage(
            String FirstName,
            String LastName,
            String Email,
            String PhoneNumber,
            String CurrentAddress,
            String Gender,
            String MonthOfBirth,
            String YearOfBirth,
            String DayOfBirth
) {

//        String FirstName = "Aleksei";
//        String LastName = "Ivanov";
        String FullName = FirstName + " " + LastName;
//        String Email = "test@test.com";
//        String PhoneNumber = "8923483745";
//        String CurrentAddress = "samara";
//        String Gender = "Male";
//        String MonthOfBirth = "August";
//        String YearOfBirth = "1991";
//        String DayOfBirth = "16";
        String BirthDay = DayOfBirth + " " + MonthOfBirth + ',' + YearOfBirth;
        String Subject = "English";
        String Hobbies = "Music";
        String Picture = "img/1.png";
        String State = "NCR";
        String City = "Delhi";
        String State_City = State + " " + City;

        registrationPage.openPage()
                .fillFirstName(FirstName)
                .fillLastName(LastName)
                .setGender(Email)
                .fillPhoneNumber(PhoneNumber)
                .fillEmail(Email)
                .fillCurrentAddress(CurrentAddress)
                .setGender(Gender)
                .setBirthDate(MonthOfBirth, YearOfBirth, DayOfBirth)
                .fillSubject(Subject)
                .setHobbies(Hobbies)
                .uploadPicture(Picture)
                .fillState(State)
                .fillCity(City)
                .submitForm();
        registrationPage.registrationPageVerifyModalAppears()
                .verifyModalResults("Student Name",FullName)
                .verifyModalResults("Student Email",Email )
                .verifyModalResults("Gender",Gender )
                .verifyModalResults("Mobile",PhoneNumber )
                .verifyModalResults("Date of Birth",BirthDay)
                .verifyModalResults("Subjects",Subject )
                .verifyModalResults("Hobbies",Hobbies )
                .verifyModalResults("Address",CurrentAddress)
                .verifyModalResults("State and City",State_City );
    }
    @CsvFileSource (resources = "/TestData.csv")
    @DisplayName("Параметризованный тест с использованием csvSourceFile")
    @ParameterizedTest
//  @Disabled
    @Tags({@Tag("Blocker"),@Tag("UI")})
    void testRegistrationPageFromFile(
            String FirstName,
            String LastName,
            String Email,
            String PhoneNumber,
            String CurrentAddress,
            String Gender,
            String MonthOfBirth,
            String YearOfBirth,
            String DayOfBirth
    ) {

//        String FirstName = "Aleksei";
//        String LastName = "Ivanov";
        String FullName = FirstName + " " + LastName;
//        String Email = "test@test.com";
//        String PhoneNumber = "8923483745";
//        String CurrentAddress = "samara";
//        String Gender = "Male";
//        String MonthOfBirth = "August";
//        String YearOfBirth = "1991";
//        String DayOfBirth = "16";
        String BirthDay = DayOfBirth + " " + MonthOfBirth + ',' + YearOfBirth;
        String Subject = "English";
        String Hobbies = "Music";
        String Picture = "img/1.png";
        String State = "NCR";
        String City = "Delhi";
        String State_City = State + " " + City;

        registrationPage.openPage()
                .fillFirstName(FirstName)
                .fillLastName(LastName)
                .setGender(Email)
                .fillPhoneNumber(PhoneNumber)
                .fillEmail(Email)
                .fillCurrentAddress(CurrentAddress)
                .setGender(Gender)
                .setBirthDate(MonthOfBirth, YearOfBirth, DayOfBirth)
                .fillSubject(Subject)
                .setHobbies(Hobbies)
                .uploadPicture(Picture)
                .fillState(State)
                .fillCity(City)
                .submitForm();
        registrationPage.registrationPageVerifyModalAppears()
                .verifyModalResults("Student Name",FullName)
                .verifyModalResults("Student Email",Email )
                .verifyModalResults("Gender",Gender )
                .verifyModalResults("Mobile",PhoneNumber )
                .verifyModalResults("Date of Birth",BirthDay)
                .verifyModalResults("Subjects",Subject )
                .verifyModalResults("Hobbies",Hobbies )
                .verifyModalResults("Address",CurrentAddress)
                .verifyModalResults("State and City",State_City );
    }
//    @ValueSource (                 используется если в метод нужно передавать 1 параметр
//          strings = {
//                  "test1",
//                  "test2"
//          }
//    )


}


