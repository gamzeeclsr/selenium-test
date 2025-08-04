/* 1.adım kullanıcı adı girilir
2. adım devam et butonuna tıklanır 
3.adım şifremi unuttum bağlanısına tıklanır.
4.adım email adresi girilir
5.adım şifre sıfırlama butonuna tıklanır.
6..adım yenileme yapılır
7.adım mail adresi girilir
8.adım şifre sıfırlama butonuna basılır
9.adım tarayıcı kapatılır.*/
package loginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ResetPasswordPage;
import pages.login_page;

public class LoginTest22 {
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
            resetPasswordPage.email_Input("gamzeeclsr@gmail.com", false);
            resetPasswordPage.clickResetButton();
            driver.navigate().refresh(); // Sayfayı yenileme işlemi
            resetPasswordPage.email_Input("gamzeec@gmail.com", false);
            resetPasswordPage.clickResetButton(); // Şifre sıfırlama butonuna tıklanır
            System.out.println("sistem istemci taraflı");

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
