/*1.adım Kullanıcı adı girişi yapılır
 * 2. adım devam et butonuna bas
 * 3.şifremi unuttum bağlantısına tıkla 
 * 4.adım e-mail adresi girilir.
 * 5.adım şifre sıfırlama bağlantısına tıklanır.
 * 6.adım çıkan başarılı mesajı tamamlanır.
 * 7.sistem 1 dk bekler
 * 8.tekrar sıfırlama bağlantısına tıklanır
 * 9.adım çıkan başarılı mesajı tammalanır
 * 10.tarayıcı kapatılır
 */
package loginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ResetPasswordPage;
import pages.login_page;

public class LoginTest19 {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://apitest.guneyeksport.com/");

            login_page LoginPage = new login_page(driver);
            LoginPage.enterUsername("Gamze", false);
            LoginPage.clickContinue();
            ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
            resetPasswordPage.clickForgotPassword();
            resetPasswordPage.email_Input("gamzeecalısır@gmail.com ", false);
            resetPasswordPage.clickResetButton();
            resetPasswordPage.clickSuccessButton();
            Thread.sleep(60000); // 1 dakika bekle
            resetPasswordPage.email_Input("gamzeeclsr@gmail.com", false);
            resetPasswordPage.clickResetButton();
            System.out.println("İkinci kez başarılı mesaj geldi, Tamam butonuna tıklandı.");
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
