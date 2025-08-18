package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResetPasswordPage {
    WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    By forgotPasswordlink = By.xpath("//*[@id='app']/div[3]/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/button");
    By emailInput = By.id("email"); // E-posta girişi için element
    By resetButton = By.xpath("//*[@id='app']/div[3]/div/div[2]/div[2]/div/div[2]/div[2]/button");
    By successMessage = By.id("swal2-title");
    By successBtn = By.xpath("/html/body/div[3]/div/div[6]/button[1]");
    By errorMessage = By.id("swal2-title");
    By isEnableButton = By.xpath("//*[@id='app']/div[3]/div/div[2]/div[2]/div/div[2]/div[2]/span");

    public void clickForgotPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fortgotPassword = wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordlink));
        fortgotPassword.click(); // Şifremi unuttum linkine tıkla
    }

    public void email_Input(String email, boolean pressEnter) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        emailField.clear(); // E-posta alanını temizle
        emailField.sendKeys(email);
        if (pressEnter) {
            emailField.sendKeys(Keys.ENTER);
            try {
                clickSuccessButton();
                System.out.println("Enter sonrası başarılı mesaj geldi, Tamam butonuna tıklandı.");
            } catch (Exception e) {
                System.out.println("Enter sonrası başarılı mesaj gelmedi veya Tamam butonu bulunamadı.");
                driver.quit(); // Tarayıcıyı kapat
                return; // Metot sonlandır
            }

        } else {
            System.out.println("enter tuşu aktif değil"); // Enter tuşuna basılmadı
        }
    }

    public void clickResetButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resetBtn = wait.until(ExpectedConditions.elementToBeClickable(resetButton));
        resetBtn.click(); // Şifre sıfırlama butonuna tıkla
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return messageElement.getText(); // Başarılı mesajını al
    }

    public void clickSuccessButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement successButton = wait.until(ExpectedConditions.elementToBeClickable(successBtn));
        successButton.click(); // Başarılı mesajdaki butona tıkla
    }

    public boolean isResetButtonEnabled() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resetBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(isEnableButton));
        return resetBtn.isEnabled();
    }// Butonun etkin olup olmadığını kontrol et

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return messageElement.getText(); // Hata mesajını al
    }
}
