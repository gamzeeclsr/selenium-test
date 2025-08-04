/*önce constructor alınır = Constructor = Class başlatılırken ilk çalışan yapı. Genellikle parametre alır ve sınıf içindeki değişkenleri başlatmak için kullanılır.
 * 
 *senaryomuza göre login_page sınıfı oluşturuldu.
 1. WebDriver'ı alır.
2. Elementlerin locator'larını tanımlar.By.id, By.xpath, By.cssSelector
3. Giriş işlemleri için gerekli metotları içerir.   
1.kullanıcı adını girer
2. devam butonuna tıklar    
3.Şifre alanına şifre girer.
4.giriş butonuna tıklar.
 */
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login_page {
    WebDriver driver; // WebDriver'ı tanımlıyoruz

    public login_page(WebDriver driver) {
        this.driver = driver; // Constructor ile WebDriver'ı alıyoruz
    }

    // elementlerin locator'larını tanımlıyoruz
    By usernameInput = By.id("username"); // Kullanıcı adı girişi için element
    By continueButton = By.xpath("//*[@id='app']/div[3]/div/div[2]/div[2]/div/div[2]/button"); // Devam butonu için
                                                                                               // element
    By passwordInput = By.id("password"); // Şifre girişi için element
    By loginButton = By.xpath("//*[@id='app']/div[3]/div/div[2]/div[2]/div/div[2]/button"); // Giriş butonu için element

    // metotlara geliyoruz

    public void enterUsername(String username, boolean pressEnter) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        userInput.clear();
        userInput.sendKeys(username);
        if (pressEnter) {
            userInput.sendKeys(Keys.ENTER);
            System.out.println("Enter basıldı, Devam butonuna ayrıca tıklanmıyor.");
        }
    }

    public void clickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueBttn = wait.until(ExpectedConditions.elementToBeClickable(continueButton)); // Devam butonunu
                                                                                                       // bekle
        continueBttn.click(); // Devam butonuna tıkla
    }

    public void enterPassword(String password, boolean pressEnter) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordfield = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordfield.clear();
        passwordfield.sendKeys(password);
        if (pressEnter) {
            passwordfield.sendKeys(Keys.ENTER);
            System.out.println("Enter basıldı, Giriş butonuna ayrıca tıklanmıyor.");
        }
    }

    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButtonelement = wait.until(ExpectedConditions.elementToBeClickable(loginButton)); // Giriş
                                                                                                          // butonunu
                                                                                                          // bekle
        loginButtonelement.click(); // Giriş butonuna tıkla
        // Giriş butonuna tıkla
    }
}
