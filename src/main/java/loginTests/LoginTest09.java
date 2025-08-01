/*9.Senaryo : “Parolamı unuttum?” bağlantısına tıklanır.
Beklenen sonuç : Şifre sıfırlama ekranına yönlendirme yapmalı.
ADIMLAR
1.TARAYICI BAŞLAT
2.GİRİŞ SAYFASINA GİT.
3.KULLANICI ADINI GİR.
4.DEVAM ET BUTONUNA BAS.
5.PAROLAMI UNUTTUM BAĞLANTISINA TIKLA.
6.ŞİFRE SIFIRLAMA EKRANINA YÖNLENDİRMELİ
 */
package loginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest09 extends LoginTest07 {
    public static void main(String[] args) {
        setupDriver(); // Tarayıcıyı başlatalım
        openLoginPage(); // Giriş sayfasına gidelim
        enterUsername("Gamze"); // Kullanıcı adını girelim
        clickContinue(); // Devam et butonuna tıklayalım
        forgotMyPassword(); // Parolamı unuttum bağlantısına tıklayalım
        checkResetPasswordPage(); // Şifre sıfırlama ekranına yönlendirme yapıldığını kontrol edelim
        driver.quit(); // Tarayıcıyı kapatalım
    }

    public static void forgotMyPassword() {
        driver.findElement(By.xpath("//*[@id='app']/div[3]/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/button")).click();
        sleep(2000);
    }

    public static void checkResetPasswordPage() {
        WebElement email = driver.findElement(By.id("email"));
        if (email.isDisplayed()) {
            System.out.println("Şifre sıfırlama ekranına yönlendirildi. Test başarılı.");
        } else {
            System.out.println("Şifre sıfırlama ekranına yönlendirilmedi.");
        }
    }
}