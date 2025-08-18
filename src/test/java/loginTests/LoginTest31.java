package loginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.login_page;

public class LoginTest31 {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://apitest.guneyeksport.com/");

            String[] usernames = { "GamZe", "gamze", "GamZE" };
            String correctPassword = "1234"; // doğru şifren neyse onu yaz

            for (String username : usernames) {
                System.out.println("Test Edilen Kullanıcı Adı: " + username);

                login_page LoginPage = new login_page(driver);
                LoginPage.enterUsername(username, false);
                LoginPage.clickContinue();

                Thread.sleep(2000); // şifre alanı geliyor mu gözlemle

                LoginPage.enterPassword(correctPassword, false);
                LoginPage.clickLogin();

                Thread.sleep(2000); // giriş başarılı mı gözlemle

                // Hata mesajı var mı kontrol et
                LoginPage.handleErrorMessageAndClickOK();

                // Sayfayı yenile veya çıkış yap
                driver.navigate().refresh();
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            System.out.println("Test sırasında hata oluştu: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Tarayıcı kapatıldı.");
            }
        }
    }
}
