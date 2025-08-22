package calısmaTestlerim;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assertionsTest {
    static WebDriver driver;

    @BeforeAll
    public static void setUpTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginTest() {
        driver.get("https://www.google.com/?hl=tr");
        String expectedData = "Google"; // beklenen veri
        String actualData = driver.getTitle(); // gerçek veri
        Assertions.assertTrue(actualData.contains(expectedData)); // içersinde yer alıyor mu diye kontrol ediyor
        // System.out.println(actualData.equals(expectedData)); true false çıktısı verir
        // Assertions.assertEquals(expectedData, actualData);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
