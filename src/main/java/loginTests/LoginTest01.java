package loginTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest01 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String link = "https://apitest.guneyeksport.com/";
        driver.get(link);

        WebElement kullanici_adi = driver.findElement(By.id("username"));
        kullanici_adi.sendKeys("");
        WebElement devam_et = driver.findElement(By.xpath("//*[@id='app']/div[3]/div/div[2]/div[2]/div/div[2]/button"));
        devam_et.click();

        WebElement uyari_mesaji = driver.findElement(By.id("swal2-html-container"));
        String mesaj = uyari_mesaji.getText();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (mesaj.equals("Lütfen kullanıcı adınızı girin")) {
            System.out.println("TEST BAŞARILI");

        } else {
            System.out.println("TEST BAŞARISIZ");
        }
        driver.quit();

    }

}
/*
 * 1.Senaryo: Kullanıcı adı boşken devam et butonuna tıklama.
 * Beklenen sonuç : Kullanıcıya "Kullanıcı adı giriniz" uyarısı göstermeli.
 */