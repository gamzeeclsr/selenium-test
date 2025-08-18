/*10. SENARYO : Şehir kodu (34) girilir, Enter yapılır
BEKLENEN SONUÇ : 34 ile başlayan plakalar listelenir*/
/*1. giriş yap
 * 2.araç takip ekranına gir.
 * 3.search ekranına 34 yaz 
 * 4.adım daha sonra özet ekranına tıkla 
 * 5.adım başında ve sonunda 34 rakamı yer alan filtreliyor mu kontrol etsin
 */

package Vehicle_TrackingTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.login_page;
import pages.vehicle_tracking;

public class vehicletracking10 {
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
            vehicletracking.vtSearch("34");
            Thread.sleep(5000);
            vehicletracking.summarytable();
            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println("test sırasıbda hata oluştu: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("tarayıcı kapatıldı");
            }
        }

    }

}
