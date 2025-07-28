package calısmaTestlerim;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dosya_yükleme {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://demo.guru99.com/test/upload/";
        driver.get(url);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
        uploadElement
                .sendKeys("C:\\Users\\gamzecalisir\\selenium-test\\src\\images\\Ekran görüntüsü 2025-07-26 084817.png");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submitbutton")).click();
    }

}
