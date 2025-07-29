package loginTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest02 {
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
        // parola alanının görüntülenip görüntülenmediğini kontrol etme
        // ve etkin olup olmadığını kontrol etme
        WebElement parola_alanı = driver.findElement(By.id("password"));
        if (parola_alanı.isDisplayed() && parola_alanı.isEnabled()) {
            System.out.println("TEST BAŞARILI " + "Parola alanı görüntüleniyor ve etkin.");
        } else {
            System.out.println("TEST BAŞARISIZ " + "Parola alanı görüntülenmiyor veya etkin değil.");
        }
        driver.quit();

    }

}
/*
 * isDisplayed() görünürlüğü kontrol eder
 * isEnabled() etkinliği kontrol eder
 * isSelected() seçili olup olmadığını kontrol eder
 * 2.Senaryo: Geçerli bir kullanıcı adı girilir ve devam et butonuna basılır.
 * Beklenen sonuç : Parola ekranına yönlendirme yapılmalı ve parola giriş alanı
 * aktif olmalı.
 */