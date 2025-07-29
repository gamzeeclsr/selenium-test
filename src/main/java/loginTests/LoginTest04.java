package loginTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest04 {
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
        WebElement giris_yap = driver
                .findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div[2]/div[2]/div/div[2]/button"));
        giris_yap.click();
        WebElement hata_mesajı = driver.findElement(By.id("swal2-html-container"));
        String mesaj = hata_mesajı.getText();
        if (mesaj.equals("Şifre giriniz")) {
            System.out.println("TEST BAŞARILI");

        } else {
            System.out.println("TEST BAŞARISIZ");
        }
        driver.quit();

    }

}
/*
 * 4.Senaryo : Parola alanı boş bırakılarak "Giriş Yap" tıklanır.
 * Beklenen sonuç : "Parola giriniz" olacak şekilde uyarı vermeli
 */