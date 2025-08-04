//özelkarakterli veri girilir
package Vehicle_TrackingTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.login_page;
import pages.vehicle_tracking;

public class vehicletracking08 {

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://apitest.guneyeksport.com/");

            login_page Loginpage = new login_page(driver);
            Loginpage.enterUsername("GAMZE", false);
            Loginpage.clickContinue();
            Loginpage.enterPassword("1234", false);
            Loginpage.clickLogin();

            Thread.sleep(3000);
            vehicle_tracking vehicletracking = new vehicle_tracking(driver);
            vehicletracking.vtSearch("63@#505");
            vehicletracking.verifyNoVehicleMarkerOnMap("63@#505");

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
