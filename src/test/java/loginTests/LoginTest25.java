package loginTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest25 {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://apitest.guneyeksport.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By aiAgentIndicator = By.xpath("//*[@id='app']/div[3]/div/div[2]/div[1]/span[1]");

            WebElement aiElement = wait.until(ExpectedConditions.visibilityOfElementLocated(aiAgentIndicator));

            // ARKA PLAN RENGİNİ AL
            String bgColor = aiElement.getCssValue("background-color");
            System.out.println("AI Agent göstergesinin ARKA PLAN renk değeri: " + bgColor);

            if (bgColor.contains("16, 185, 129")) {
                System.out.println(" AI sistemi çalışıyor - yeşil gösterge var");
            } else {
                System.out.println(" Hata: AI göstergesi yeşil değil! Renk: " + bgColor);
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
