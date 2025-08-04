package loginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.login_page;

public class LoginTest33 {

    public static void main(String[] args) {
        runTestOn("chrome");
    }

    public static void runTestOn(String browser) {
        WebDriver driver = null;
        System.out.println(" Test başlıyor: " + browser);

        try {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.get("https://apitest.guneyeksport.com/");

            login_page LoginPage = new login_page(driver);
            LoginPage.enterUsername("Gamze", false);
            LoginPage.clickContinue();
            LoginPage.enterPassword("1234", false);
            LoginPage.clickLogin();

            Thread.sleep(2000); // kısa bekleme — site yüklenmesi için

            LoginPage.handleErrorMessageAndClickOK();

        } catch (Exception e) {
            System.out.println("❌ Hata oluştu: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("✅ Test tamamlandı: " + browser);
            }
        }
    }
}
