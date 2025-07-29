package loginTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest06 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String link = "https://apitest.guneyeksport.com/";
        driver.get(link);

        WebElement kullanici_adi = driver.findElement(By.id("username"));
        kullanici_adi.sendKeys("gamze");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement devam_et = driver.findElement(By.xpath("//*[@id='app']/div[3]/div/div[2]/div[2]/div/div[2]/button"));
        devam_et.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement parola_alanı = driver.findElement(By.id("password"));
        parola_alanı.sendKeys("1234");
        WebElement giris_yap = driver
                .findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div[2]/div[2]/div/div[2]/button"));
        giris_yap.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://apitest.guneyeksport.com/vehicle-tracking"));
        String beklenen_adres = "https://apitest.guneyeksport.com/vehicle-tracking";
        String gidilen_adres = driver.getCurrentUrl();
        if (gidilen_adres.equals(beklenen_adres)) {
            System.out.println("TEST BAŞARILI");
        } else {
            System.out.println("TEST BAŞARISIZ");
        }
        driver.quit();
    }

}
/*
 * 6.Senaryo : Doğru kullanıcı adı + doğru parola girişi deneme
 * Beklenen sonuç : Başarılı bir şekilde sisteme giriş yapılır.
 */
