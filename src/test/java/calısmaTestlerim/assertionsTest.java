package calısmaTestlerim;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assertionsTest {
    static WebDriver driver = null;

    @BeforeClass
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
        Assert.assertTrue(actualData.contains(expectedData));

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
