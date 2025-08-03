/*1.kullanıcı adınızı girin
 * 2. devam et butonuna basın
 * 3.şifre sıfırlama bağlantısına tıklanıyınız
 * 4.mail adresinizi giriniz
 * 5.enter tuşuna basınız.
 */
package loginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ResetPasswordPage;
import pages.login_page;

public class LoginTest15 {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://apitest.guneyeksport.com/");
            login_page Login_page = new login_page(driver);
            Login_page.enterUsername("gamze");
            Login_page.clickContinue();
            ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
            resetPasswordPage.clickForgotPassword();
            resetPasswordPage.email_Input("gamzeeclsr@gmail.com", true); // enter tuşuna basmasını istiyorum

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
