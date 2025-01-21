package pages;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker();
//    Faker faker = new Faker(new Locale("ru"));
    public String   FirstName = faker.name().firstName(),
                    LastName = faker.name().lastName(),
                    FullName = FirstName + " " + LastName,
                    Email = faker.internet().emailAddress(),
                    PhoneNumber = faker.phoneNumber().subscriberNumber(10),
                    CurrentAddress = faker.address().fullAddress(),
                    Gender = "Male",
                    MonthOfBirth = "August",
                    YearOfBirth = "1991",
                    DayOfBirth = "16",
                    BirthDay = DayOfBirth + " " + MonthOfBirth + ',' + YearOfBirth,
                    Subject = "English",
                    Hobbies = "Music",
                    Picture = "img/1.png",
                    State = "NCR",
                    City = "Delhi",
                    State_City = State + " " + City;
}
