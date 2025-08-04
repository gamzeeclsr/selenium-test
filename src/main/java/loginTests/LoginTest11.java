/*1.adım kullanıcı adı girilir
 * 2. adım devam et butonuna tıklanır
 * 3.adım şifremi unuttum bağlantısına tıklanır
 * 4.adım geçersiz e-mail adresi girilir
 * 5.şifre sıfırlama butonuna tıklanır
 * 6. adım lütfen e-posta adresinizi kontrol edin diye mesaj göstermelidir
 */

package loginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ResetPasswordPage;
import pages.login_page;

public class LoginTest11 {
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
            resetPasswordPage.email_Input("jhsdfdskfhdkjshfkj", false);
            resetPasswordPage.clickResetButton();
            String errorMessage = resetPasswordPage.getErrorMessage();
            System.out.println("Hata mesajı: " + errorMessage);
            if (errorMessage.equals("Lütfen e-posta adresinizi kontrol edin.")) {
                System.out.println("Test başarılı: Hata mesajı doğru.");
            } else {
                System.out.println("Test başarısız: Hata mesajı beklenenden farklı.");
            }
        } catch (Exception e) {
            System.out.println("test sırasında hata oluştu:" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Tarayıcı kapatıldı.");
            }
        }

    }

}
