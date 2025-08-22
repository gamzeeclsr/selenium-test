package calısmaTestlerim;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class junitdeneme {
    WebDriver driver;

    @BeforeEach
    public void hazirlikyap() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void ziyaretet() throws InterruptedException {
        driver.get("https://www.facebook.com/?locale=tr_TR");
        Thread.sleep(2000); // test gözlemlenebilir olsun diye
    }

    @Test
    public void googlegiris() throws InterruptedException {
        driver.get("https://www.google.com/?hl=tr");
        Thread.sleep(2000);
    }

    @AfterEach
    public void cikisYap() {
        if (driver != null) {
            driver.quit();
        }
    }
}
