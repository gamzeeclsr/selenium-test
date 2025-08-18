package loginTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest03 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String link = "https://apitest.guneyeksport.com/";
        driver.get(link);

        WebElement kullanici_adi = driver.findElement(By.id("username"));
        kullanici_adi.sendKeys("SEZEN");
        WebElement devam_et = driver.findElement(By.xpath("//*[@id='app']/div[3]/div/div[2]/div[2]/div/div[2]/button"));
        devam_et.click();

        System.out.println("TEST BAŞARISIZ,ÇIKTI OLARAK KULLANICI BULUNAMADI HATASI DÖNDÜRMÜYOR");

    }

}

/*
 * 3.Senaryo: Kayıtlı olmayan bir kullanıcı adı girilir.
 * Beklenen sonuç : Kullanıcı bulunamadı hatası döndürülmeli
 */