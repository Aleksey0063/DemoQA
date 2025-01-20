package qademo;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import qademo.model.Glossary;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FileParsing {

    ClassLoader cl = FileParsing.class.getClassLoader();

    @Test
    void pdfParsingTest () throws Exception{
        open("https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests");
        File downloadedPDF = $("a[href = 'junit-user-guide-5.11.4.pdf']").download();
        try (InputStream is = new FileInputStream(downloadedPDF)){
            PDF content = new PDF(downloadedPDF);
            assertThat(content.author).contains("Sam Brannen");
        }
    }

    @Test
    void xlsParsingTest () throws Exception {
       try(InputStream resourseAsStream = cl.getResourceAsStream("test.xlsx")){
           XLS content = new XLS(resourseAsStream);
           assertThat(content.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue().contains("test"));
       }

    }

    @Test
    void csvParsingTest() throws Exception{
    try(
            InputStream resourse = cl.getResourceAsStream("testcsv.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(resourse));
    ){
        List<String[]> content = reader.readAll();
        assertThat(content.get(0)[1]).contains("1");

    }
    }

    @Test
    void zipParsingTest() throws Exception{
        try(
                InputStream resoursezip = cl.getResourceAsStream("result.zip");
                ZipInputStream zis = new ZipInputStream(resoursezip);

        ){
            ZipEntry entry;
            while ( (entry = zis.getNextEntry()) != null ) {
                assertThat(entry.getName()).contains("req_preview");
            }

        }
    }

    @Test
    void jsonParsingTest() throws Exception{
        Gson gson = new Gson();
        try(
                InputStream resoursejson = cl.getResourceAsStream("testJson.json");
                InputStreamReader isr = new InputStreamReader(resoursejson);

        ){
            JsonObject jsonObject = gson.fromJson(isr, JsonObject.class);
            assertThat(jsonObject.get("glossary").getAsJsonObject().get("title").getAsString()).isEqualTo("example glossary");
        }
    }

    @Test
    void jsonParsingTestimp() throws Exception{
        Gson gson = new Gson();
        try(
                InputStream resoursejson = cl.getResourceAsStream("testJsonimp.json");
                InputStreamReader isr = new InputStreamReader(resoursejson);

        ){
            Glossary jsonObject = gson.fromJson(isr, Glossary.class);
            assertThat(jsonObject.title).isEqualTo("example glossary");
            assertThat(jsonObject.glossDiv.flag).isEqualTo(true);
        }
    }
}
