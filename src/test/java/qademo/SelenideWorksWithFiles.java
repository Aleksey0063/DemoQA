package qademo;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.ex.FileNotDownloadedError;
import com.google.common.base.Utf8;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelenideWorksWithFiles {


//   static {
//       Configuration.fileDownload = FileDownloadMode.PROXY;
//   }
//    используется если кнопка скачивания не содержит href

    @Test
    void selenideDownloadTest () throws Exception {
        open("https://github.com/junit-team/junit5");
        File downloadedFile = $$(".Link--primary").findBy(text("NOTICE.md")).download();
        try (InputStream is = new FileInputStream(downloadedFile)){
            byte[] bytes = is.readAllBytes();
            String textContent = new String(bytes, StandardCharsets.UTF_8);
            assertThat(textContent).contains("This product may include");
        }


    }

    @BeforeAll
    static void setUptest() {
        Configuration.pageLoadTimeout = 90000;
    }
    @Test
    void  selenideUploadTest (){
        open("https://demoqa.com/automation-practice-form");
        $("input[type= 'file']").uploadFromClasspath("img/1.png");
    }
}
