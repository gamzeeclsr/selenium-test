package calısmaTestlerim;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class sag_tıklama {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String lnk = "https://demo.guru99.com/test/simple_context_menu";
        driver.get(lnk);

        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.xpath("//*[@id='authentication']/span"));
        actions.contextClick(button).perform(); // butona sağ tıkla süreci için

        WebElement copy = driver.findElement(By.xpath("//*[@id='authentication']/ul/li[3]"));
        copy.click(); // sağ tıklama menüsünden "copy" seçeneğine tıkla

        driver.switchTo().alert().accept(); // açılan alert penceresini kabul ediyor
    }

}
