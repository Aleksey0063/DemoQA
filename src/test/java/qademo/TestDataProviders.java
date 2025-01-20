package qademo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class TestDataProviders {
    static Stream<Arguments> SelenideSiteShouldHaveButtons (){
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(qademo.Locale.EN, List.of("Quick start","Docs","FAQ","Blog","Javadoc","Users","Quotes")),
                org.junit.jupiter.params.provider.Arguments.of(Locale.RU, List.of("С чего начать?","Док","ЧАВО","Блог","Javadoc","Пользователи","Отзывы"))
        );
    }

    @MethodSource
    @ParameterizedTest

    void SelenideSiteShouldHaveButtons (qademo.Locale locale, List<String> buttons){
    open("https://ru.selenide.org");
    $$("#languages").findBy(text(locale.name())).click();
   // $$("#languages").findBy(text("EN")).click();
    $$(".main-menu-pages a").filter(visible).findBy(text("Quick start")).shouldBe(visible);
    $$(".main-menu-pages a").filter(visible).shouldHave(texts(buttons));
    }
}
