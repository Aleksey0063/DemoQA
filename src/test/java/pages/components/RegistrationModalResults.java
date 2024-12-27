package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationModalResults {
    public void regitrationPageModalAppears(){
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
    public void verifyResults(String Label,String Value){
        $(".table-responsive").$(byText(Label)).parent()
                .shouldHave(text(Value));

    }

}
