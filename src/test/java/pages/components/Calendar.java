package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    public void setDate (String Month, String Year, String Day){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(Month);
        $(".react-datepicker__year-select").selectOption(Year);
        $(".react-datepicker__day--0" + Day + " ").click();
    }
}
