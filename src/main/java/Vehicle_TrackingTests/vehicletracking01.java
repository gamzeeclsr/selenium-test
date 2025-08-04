/*araç takip ekranına giriş yapabilmek için gerekli durumlar
1.login ekranına git
2.kullanıcı adını gir
3.devam butonuna bas
4.şifre gir
5.giriş yap 
6.araç takip search kısmına gel
7.istenilen veriyi gir
8.enter tuşuna bas
9.çıktıyı kontrol et
 */
package Vehicle_TrackingTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.login_page;
import pages.vehicle_tracking;

public class vehicletracking01 {

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
            vehicletracking.vtSearch("63LH505");
            vehicletracking.verifyVehicleMarkerOnMap("63LH505");

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
