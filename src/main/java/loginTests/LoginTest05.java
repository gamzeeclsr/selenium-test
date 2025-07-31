package loginTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest05 {
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
        parola_alanı.sendKeys("568753");
        WebElement giris_yap = driver
                .findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div[2]/div[2]/div/div[2]/button"));
        giris_yap.click();

        WebElement hata_mesajı = driver.findElement(By.id("swal2-html-container"));
        String mesaj = hata_mesajı.getText();
        if (mesaj.equals("PAROLA HATALI BİLGİLERİNİZİ KONTROL EDİP DAHA SONRA TEKRAR DENEYİNİZ !")) {
            System.out.println("TEST BAŞARILI");
        } else {
            System.out.println("TEST BAŞARISIZ");
        }

        // driver.quit();

    }

}
/*
 * 5.Senaryo : Doğru kullanıcı adı + yanlış parola girişi deneme
 * Beklenen sonuç : “Parola hatalı” uyarısı döndürmeli.
 */
