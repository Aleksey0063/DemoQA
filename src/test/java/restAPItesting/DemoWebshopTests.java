package restAPItesting;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.given;

public class DemoWebshopTests {
    @BeforeAll
    public static void setUp (){
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
    }
    @Test
    void addToCartTest () {
        String coolieValue = "7A5746A9897E2329F1ECB7E4A4B0DE2FA9EC4DE85B85ECF8E014E278EAB10C21D4A6D13EEC26FD48A68AE5F76C34FE43AAA5473A357B5097B138DD300B14BAA73ABC5E35103D567C82481EF2E343BC950041F85F0C3DB5C0BD0070A6BA00FAEDD911A4E00938D66ED42EDC908E9308B8B60F4A0AB40465594670434FA1A1E768009177325E754C6C0410BAE7C30AEF8AD6F6BEB2DE51860B1733AD078FD05BBD";
        String body = "product_attribute_16_5_4=14&product_attribute_16_6_5=15&product_attribute_16_3_6=19&product_attribute_16_4_7=44&product_attribute_16_8_8=22&addtocart_16.EnteredQuantity=1";
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("NOPCOMMERCE.AUTH", coolieValue)
                .body(body)
                .when()
                .post("/addproducttocart/details/16/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success",is(true))
                .body("message",is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
        ;
    }
}
