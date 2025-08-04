/*
6.araç takip search kısmına gel
7.istenilen veriyi gir
8.enter tuşuna bas
9.çıktıyı kontrol et
 */
package pages;

import java.time.Duration;

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

    public void vtSearch(String plaka) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(vt_search));
        searchInput.clear();
        searchInput.sendKeys(plaka);
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
            System.out.println("  Geçersiz plaka olmasına rağmen  görünüyor! (" + plaka + ")");
        } catch (Exception e) {
            System.out.println(" Beklendiği gibi " + plaka + " plakalı araç haritada görünmüyor.");
        }
    }
}
