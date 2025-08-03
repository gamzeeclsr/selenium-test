/*1.kullanıcı adını girin
2.devam et butonuna basın
3.parolamı unuttum bağlantısına tıkla 
4.e-mail adresini gir 
5.şifre sıfırlama bağlantısına tıkla
6.çıkan onay kutusuna tamam de
7.şifre sıfırlama ekranındaki butonun devre dışı(disable) olduğunu kontrol et */
package loginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ResetPasswordPage;
import pages.login_page;

public class LoginTest14 {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://apitest.guneyeksport.com/");

            login_page LoginPage = new login_page(driver);
            LoginPage.enterUsername("gamze");
            LoginPage.clickContinue();

            ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
            resetPasswordPage.clickForgotPassword();
            resetPasswordPage.email_Input("gamze@gmail.com", false);
            resetPasswordPage.clickResetButton();
            resetPasswordPage.clickSuccessButton();
            resetPasswordPage.isResetButtonEnabled();
            if (resetPasswordPage.isResetButtonEnabled()) {
                System.out.println("Şifre sıfırlama butonu devre dışı (disable) olarak ayarlandı.");
            } else {
                System.out.println("Şifre sıfırlama butonu etkin (enable) durumda.");
            }

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