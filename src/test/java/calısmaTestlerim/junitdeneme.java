package calısmaTestlerim;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class junitdeneme {
    WebDriver driver = null;

    @Before
    public void hazirlikyap() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void ziyaretet() {
        driver.get("https://www.facebook.com/?locale=tr_TR");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void googlegiris() {
        driver.get("https://www.google.com/?hl=tr");
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @After
    public void cıkısyao() {
        driver.quit();
    }

}
