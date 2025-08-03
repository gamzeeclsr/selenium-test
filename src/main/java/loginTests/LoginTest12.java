/*1. adım kullanıcı adı girilir
 * 2. adım devam et butonuna tıklanır.
 * 3.adım şifremi unuttum bağlantısına tıklanır
 * 4.adım e-mail adresi boş bırakılır
 * 5.adım şifre sıfırlama butonuna tıklanır
 * 6.adım hata mesajı alınır
 */
package loginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ResetPasswordPage;
import pages.login_page;

public class LoginTest12 {

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://apitest.guneyeksport.com/");
            login_page LoginPage = new login_page(driver);
            LoginPage.enterUsername("Gamze");
            LoginPage.clickContinue();

            ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
            resetPasswordPage.clickForgotPassword();
            resetPasswordPage.email_Input("", false); // E-posta alanı boş bırakılır
            resetPasswordPage.clickResetButton();
            String errorMessage = resetPasswordPage.getErrorMessage();
            System.out.println("Hata mesajı: " + errorMessage);
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
