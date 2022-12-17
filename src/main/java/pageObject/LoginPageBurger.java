package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageBurger {
    private WebDriver driver;
    private RegistrationPageBurger registrationPageBurger = new RegistrationPageBurger();

    private By loginHomePage = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx");
    private By loginRegistration = By.className("Auth_link__1fOlj"); // однотипный для регистрации и восстановления пароля
    private By forgotPassword = By.xpath(".//a[@href='/forgot-password']");
    private By login = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx");

    private By email = By.xpath(".//input[@type='text']");
    private By password = By.xpath(".//input[@type='password']");
    private By loginOk = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx");
    private By exit = By.cssSelector(".Account_button__14Yp3.text.text_type_main-medium.text_color_inactive");
    private By exitOk = By.xpath(".//div[@class='Auth_login__3hAey']//button");

    public LoginPageBurger(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Login new default user to HomePage")
    public void sendInfoForSuccessfulLoginHomePage() {
        driver.findElement(loginHomePage).click();
        driver.findElement(email).sendKeys(RandomInfo.RANDOM_EMAIL);
        driver.findElement(password).sendKeys(RandomInfo.RANDOM_PASSWORD);
        driver.findElement(login).click();
    }

    @Step("Login new default user to login account")
    public void sendInfoForSuccessfulLoginAccount() {
        driver.findElement(registrationPageBurger.getAccount()).click();
        driver.findElement(email).sendKeys(RandomInfo.RANDOM_EMAIL);
        driver.findElement(password).sendKeys(RandomInfo.RANDOM_PASSWORD);
        driver.findElement(login).click();
    }

    @Step("Login new default user to registration form")
    public void sendInfoForSuccessfulLoginRegistrationForm() {
        driver.findElement(registrationPageBurger.getAccount()).click();
        driver.findElement(registrationPageBurger.getRegister()).click();
        driver.findElement(loginRegistration).click();
        driver.findElement(email).sendKeys(RandomInfo.RANDOM_EMAIL);
        driver.findElement(password).sendKeys(RandomInfo.RANDOM_PASSWORD);
        driver.findElement(login).click();
    }

    @Step("Login new default user to forgot password form")
    public void sendInfoForSuccessfulLoginForgotPasswordForm() {
        driver.findElement(registrationPageBurger.getAccount()).click();
        driver.findElement(forgotPassword).click();
        driver.findElement(loginRegistration).click();
        driver.findElement(email).sendKeys(RandomInfo.RANDOM_EMAIL);
        driver.findElement(password).sendKeys(RandomInfo.RANDOM_PASSWORD);
        driver.findElement(login).click();
    }

    @Step("Massage for success login")
    public String getTextForSuccessfulLogin(){
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(loginOk)).getText();
    }

    @Step("Exit new default user to account")
    public void sendInfoForExitUserToAccount() {
        driver.findElement(registrationPageBurger.getAccount()).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(exit)).click();
    }

    @Step("Go in personal account")
    public void sendInfoForGoPersonalAccount() {
        driver.findElement(email).sendKeys(RandomInfo.RANDOM_EMAIL);
        driver.findElement(password).sendKeys(RandomInfo.RANDOM_PASSWORD);
        driver.findElement(login).click();
        driver.findElement(registrationPageBurger.getAccount()).click();
    }


    @Step("Massage for success exit user to account")
    public String getTextForSuccessfulExitUser(){
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(exitOk)).getText();
    }
}
