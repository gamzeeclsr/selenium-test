package loginTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest07 {
    static WebDriver driver;

    public static void main(String[] args) {
        setupDriver();
        openLoginPage();
        enterUsername("gamze.c");
        clickContinue();
        clickRememberMe();
        enterPassword("54321");
        veriftyLogin("https://apitest.guneyeksport.com/vehicle-tracking");
        profile();
        logout();
        LogoutSuccessful();
        driver.quit();

    }

    // Tarayıcıyı başlatalım
    public static void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Giriş sayfasına gidelim
    public static void openLoginPage() {
        driver.get("https://apitest.guneyeksport.com/");
    }

    // Kullanıcı adını girelim
    public static void enterUsername(String username) {
        WebElement user_name = driver.findElement(By.id("username"));
        user_name.sendKeys(username);
        sleep(2000);
    }

    // Devam et butonuna tıklayalım
    public static void clickContinue() {
        WebElement continueButton = driver
                .findElement(By.xpath("//*[@id='app']/div[3]/div/div[2]/div[2]/div/div[2]/button"));
        continueButton.click();

    }

    // Şifreyi gir ve giriş yap
    public static void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        sleep(2000);
        WebElement LoginButton = driver
                .findElement(By.xpath("//*[@id='app']/div[3]/div/div[2]/div[2]/div/div[2]/button"));
        LoginButton.click();
        sleep(2000);

    }
    // beni hatırla butonunu aktifleyeceğim

    public static void clickRememberMe() {
        WebElement rememberButton = driver
                .findElement(By.xpath("//*[@id='app']/div[3]/div/div[2]/div[2]/div/div[2]/div[2]/div"));
        rememberButton.click();
        sleep(2000);
    }

    // Beklenen sayfaya gidildi mi kontrol et
    public static void veriftyLogin(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("TEST BAŞARILI");
        } else {
            System.out.println("TEST BAŞARISIZ");
        }
    }

    // profile tıklayalım
    public static void profile() {
        WebElement profileButton = driver
                .findElement(By.xpath("//*[@id='app']/div[3]/div[1]/div[1]/div[2]/div[2]/button"));
        profileButton.click();
        sleep(2000);
    }

    // çıkış yapalım
    public static void logout() {
        WebElement logoutButton = driver
                .findElement(By.xpath("//*[@id='app']/div[3]/div[1]/div[1]/div[2]/div[2]/div/button"));
        logoutButton.click();
        sleep(2000);
    }

    // çıkış yapınca kullanıcı adı alanı görünüyor mu
    public static void LogoutSuccessful() {
        WebElement usernameField = driver.findElement(By.id("username"));
        if (usernameField.isDisplayed()) {
            System.out.println("Kullanıcı adı alanı görünür." + "test başarılı");
        } else {
            System.out.println("Kullanıcı adı alanı görünür değil.");
        }

    }

    // Bekleme metodu
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
