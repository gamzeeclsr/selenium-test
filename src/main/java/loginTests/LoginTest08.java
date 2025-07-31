package loginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest08 extends LoginTest07 {
    public static void main(String[] args) {
        setupDriver(); // Tarayıcıyı başlatalım
        openLoginPage(); // Giriş sayfasına gidelim
        enterUsername("Gamze"); // Kullanıcı adını girelim
        clickContinue(); // Devam et butonuna tıklayalım
        clickback(); // Geri butonuna tıklayalım
        checkUsernameField(); // Kullanıcı adı alanının geldi mi kontrol edelim
        driver.quit(); // Tarayıcıyı kapatalım
    }

    public static void clickback() {
        WebElement backbutton = driver
                .findElement(By.xpath("//*[@id='app']/div[3]/div/div[2]/div[2]/div/div[1]/button"));
        backbutton.click();
        sleep(5000);
    }

    public static void checkUsernameField() {
        WebElement usernameField = driver.findElement(By.xpath("//*[@id='username']"));
        if (usernameField.isDisplayed()) {
            System.out.println("Kullanıcı adı alanı görüntüleniyor." + "test başarılı");
        } else {
            System.out.println("Kullanıcı adı alanı görüntülenmiyor.");
        }
    }

}
