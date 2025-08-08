/*
6.araç takip search kısmına gel
7.istenilen veriyi gir
8.enter tuşuna bas
9.çıktıyı kontrol et
 */
package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class vehicle_tracking {
    WebDriver driver;

    public vehicle_tracking(WebDriver driver) {
        this.driver = driver;
    }

    By vt_search = By.xpath("//*[@id='app']/div[3]/div[2]/div[2]/label/input");
    By car_bttn = By.xpath("//*[@id='app']/div[3]/div[2]/div[4]/div[1]/div/div[3]/div[1]/div[2]/div/div[3]/div");
    By group_details = By.xpath("//*[@id='app']/div[3]/div[2]/div[2]/div[2]");

    public void vtSearch(String plaka) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(vt_search));
        searchInput.clear();
        searchInput.sendKeys(plaka);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void car() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cars = wait.until(ExpectedConditions.visibilityOfElementLocated(car_bttn));
        cars.click();
    }

    public void groupdetails(String expectedSuffix) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement detailsdiv = wait.until(ExpectedConditions.visibilityOfElementLocated(group_details)); // grup
                                                                                                          // detaylarının
                                                                                                          // olduğu divi
                                                                                                          // bulacak
        String detailtext = detailsdiv.getText(); // grup içindeki metnin değerlerini al
        String[] plates = detailtext.split("\\r?\\n"); // her plakayı tek bir ayrı eleman olarak erişebilmek için
                                                       // satırlara bölüyorum.

        boolean allEndWithExpected = Arrays.stream(plates)
                .map(String::trim) // plakanın başındaki ve sonundaki boşlukları temizler
                .filter(plate -> !plate.isEmpty()) // boş olan plakam varsa ayıklar
                .allMatch(plate -> plate.endsWith(expectedSuffix)); // tüm plakalar istenilen detayla bitiyor mu diye
                                                                    // kontrol eder.

        // 5. Sonucu ekrana yaz
        if (allEndWithExpected) {
            System.out.println(" Tüm plakalar " + expectedSuffix + " ile bitiyor.");
        } else {
            System.out.println(" Bazı plakalar " + expectedSuffix + " ile bitmiyor!");
            // İstersen detayları da yazdıralım:
            for (String plate : plates) {
                if (!plate.trim().isEmpty() && !plate.trim().endsWith(expectedSuffix)) {
                    System.out.println("Hatalı plaka: " + plate);
                }
            }
        }
    }

    public void clearSearchAndEnter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(vt_search));
        searchInput.clear();
        searchInput.sendKeys(Keys.ENTER);
    }

    public void verifyVehicleMarkerOnMap(String plaka) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String dynamicXpath = String.format("//div[@title='%s']", plaka); // s string yer tutucu durumu
        By markerBy = By.xpath(dynamicXpath);

        try {
            WebElement marker = wait.until(ExpectedConditions.visibilityOfElementLocated(markerBy));
            if (marker.isDisplayed()) {
                System.out.println("Haritada " + plaka + " plakalı araç görünüyor.");
            } else {
                System.out.println(" Araç görünmüyor.");
            }
        } catch (Exception e) {
            System.out.println(" HATA: " + plaka + " plakalı araç bulunamadı. Detay: " + e.getMessage());
        }
    }

    public void verifyNoVehicleMarkerOnMap(String plaka) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String dynamicXpath = String.format("//div[@title='%s']", plaka);
        By markerBy = By.xpath(dynamicXpath);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(markerBy));
            System.out.println("  tüm plakalar listelendi" + plaka + ")");
        } catch (Exception e) {
            System.out.println(" Beklendiği gibi " + plaka + " plakalı araç haritada görünmüyor.");
        }
    }

}
