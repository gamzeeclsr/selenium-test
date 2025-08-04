package loginTests;

/*1.tarayıcıyı aç
 * 2.kullanıcı adını gir
 * 3.devam et butonuna bas
 * 4."Parolamı unuttum?" bağlantısına tıkla
 * 5.geçerli bir e-posta adresi gir
 * 6.sıfırlama bağlantısı göndere tıkla
 * 7.başarılı mesajını kontrol et
 * 8.tarayıcıyı kapat
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.login_page;

public class LoginTest10 {
    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://apitest.guneyeksport.com/");

            login_page loginPage = new login_page(driver);

            loginPage.enterUsername("Gamze", false);
            loginPage.clickContinue();

            loginPage.enterPassword("1234", false);
            loginPage.clickLogin();

            // İstersen buraya doğrulama veya başka test adımları ekleyebilirsin

            System.out.println("Test tamamlandı.");

        } catch (Exception e) {
            System.out.println("Test sırasında hata oluştu: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Tarayıcı kapatıldı.");
            }
        }
    }
}
