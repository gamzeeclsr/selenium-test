package Vehicle_TrackingTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.login_page;
import pages.vehicle_tracking;

public class vehicletracking09 {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://apitest.guneyeksport.com/");

            login_page LoginPage = new login_page(driver);
            LoginPage.enterUsername("aysegüllll", false);
            LoginPage.clickContinue();
            LoginPage.enterPassword("A", false);
            LoginPage.clickLogin();

            Thread.sleep(5000);
            vehicle_tracking vehicletracking = new vehicle_tracking(driver);
            vehicletracking.vtSearch("505");
            Thread.sleep(2000);
            vehicletracking.car();
            Thread.sleep(3000);
            vehicletracking.groupdetails("505");

        } catch (Exception e) {
            System.out.println("test sırasında hata oluştu: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("tarayıcı kapatıldı");
            }
        }
    }

}
