package loginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.login_page;

public class LoginTest23 {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://apitest.guneyeksport.com/");

            login_page LoginPage = new login_page(driver);
            LoginPage.enterUsername("gamze", false);
            LoginPage.clickContinue();
            LoginPage.enterPassword("1234", false);

            WebElement passwordField = driver.findElement(By.id("password"));
            String typeAttribute = passwordField.getAttribute("type");
            if (!"password".equals(typeAttribute)) {
                System.out.println("(type='password' değil)");
            } else {
                System.out.println(" Test başarılı: Parola alanı gizli");
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
