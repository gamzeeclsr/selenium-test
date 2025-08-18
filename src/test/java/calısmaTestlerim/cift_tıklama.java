package calısmaTestlerim;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class cift_tıklama {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String lnhk = "https://demo.guru99.com/test/simple_context_menu";
        driver.get(lnhk);

        Actions actions = new Actions(driver);
        WebElement d_bttn = driver.findElement(By.xpath("//button[text() = 'Double-Click Me To See Alert']"));
        actions.doubleClick(d_bttn).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();

    }

}
