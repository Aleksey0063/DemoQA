package properties;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {

    @Test
    void simplePropertyTest(){
        System.setProperty("browser", "opera");
        String browserName = System.clearProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void simplePropertyTest1(){
        String browserName = System.getProperty("browser","firefox");
        System.out.println(browserName);
        // gradle clean one_property_test
        // gradle clean one_property_test -Dbrowsser=safari  -запускает таску one_property_test (билд грэдл файлик)
    }
}
