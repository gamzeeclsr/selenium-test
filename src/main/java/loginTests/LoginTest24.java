/*1.adım kullanıcı adı girilir
 * 2.adım enter tuşuna basılır
 * 3.adım şifre alanı girilir
 * 4.adım enter tuşuna basılır
 * 5.adım başarılı mesajı alınır.
 */
package loginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.login_page;

public class LoginTest24 {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://apitest.guneyeksport.com/");

            login_page LoginPage = new login_page(driver);
            LoginPage.enterUsername("Gamze", true);
            Thread.sleep(2000);
            LoginPage.enterPassword("1234", true);

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
