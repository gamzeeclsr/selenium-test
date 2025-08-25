package Vehicle_TrackingTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.login_page;
import pages.vehicle_tracking;

public class vehicletracking11 {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://apitest.guneyeksport.com/");

            login_page Loginpage = new login_page(driver);
            Loginpage.enterUsername("aysegüllll", false);
            Loginpage.clickContinue();
            Loginpage.enterPassword("A", false);
            Loginpage.clickLogin();
            Thread.sleep(3000);

            vehicle_tracking vehicletracking = new vehicle_tracking(driver);
            vehicletracking.filo();
            Thread.sleep(3000);

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
