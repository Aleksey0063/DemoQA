package qademo;
import org.junit.jupiter.api.Test;


public class Qademo extends TestBase {

    @Test
    void testRegistrationPage() {

        String FirstName = "Aleksei";
        String LastName = "Ivanov";
        String FullName = FirstName + " " + LastName;
        String Email = "test@test.com";
        String PhoneNumber = "8923483745";
        String CurrentAddress = "samara";
        String Gender = "Male";
        String MonthOfBirth = "August";
        String YearOfBirth = "1991";
        String DayOfBirth = "16";
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
}
