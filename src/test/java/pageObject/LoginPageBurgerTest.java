package pageObject;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class LoginPageBurgerTest {
    WebDriver driver = new ChromeDriver();
    LoginPageBurger objLoginPageBurger = new LoginPageBurger(driver);
    RegistrationPageBurger objRegistrationPageBurger = new RegistrationPageBurger(driver);

    @SneakyThrows
    @Before
    public void setUp() {
        driver.get("https://stellarburgers.nomoreparties.site/");

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @SneakyThrows
    @DisplayName("Login new default user to registration form")
    @Test
    public void shouldSuccessfulLoginRegistrationForm() {
        objRegistrationPageBurger.sendInfoForSuccessfulRegistration();
        TimeUnit.SECONDS.sleep(2);
        objLoginPageBurger.sendInfoForSuccessfulLoginRegistrationForm();
        TimeUnit.SECONDS.sleep(2);
        String expected = "Оформить заказ";
        String actual = objLoginPageBurger.getTextForSuccessfulLogin();
        assertEquals("Login new user impossible",expected, actual);
    }

    @SneakyThrows
    @DisplayName("Login new default user to login account")
    @Test
    public void shouldSuccessfulLoginAccount() {
        objRegistrationPageBurger.sendInfoForSuccessfulRegistration();
        TimeUnit.SECONDS.sleep(2);
        objLoginPageBurger.sendInfoForSuccessfulLoginAccount();
        TimeUnit.SECONDS.sleep(2);
        String expected = "Оформить заказ";
        String actual = objLoginPageBurger.getTextForSuccessfulLogin();
        assertEquals("Login new user impossible",expected, actual);
    }


    @SneakyThrows
    @DisplayName("Login new default user to HomePage")
    @Test
    public void shouldSuccessfulLoginHomePage() {
        TimeUnit.SECONDS.sleep(2);
        objLoginPageBurger.sendInfoForSuccessfulLoginHomePage();
        TimeUnit.SECONDS.sleep(2);
        String expected = "Оформить заказ";
        String actual = objLoginPageBurger.getTextForSuccessfulLogin();
        assertEquals("Login new user impossible",expected, actual);
    }

    @SneakyThrows
    @DisplayName("Login new default user to forgot password form")
    @Test
    public void shouldSuccessfulLoginForgotPasswordForm() {
        objRegistrationPageBurger.sendInfoForSuccessfulRegistration();
        TimeUnit.SECONDS.sleep(2);
        objLoginPageBurger.sendInfoForSuccessfulLoginForgotPasswordForm();
        TimeUnit.SECONDS.sleep(2);
        String expected = "Оформить заказ";
        String actual = objLoginPageBurger.getTextForSuccessfulLogin();
        assertEquals("Login new user impossible",expected, actual);
    }

    @SneakyThrows
    @DisplayName("Exit new default user to account")
    @Test
    public void shouldSuccessfulExitUserToAccount() {
        objLoginPageBurger.sendInfoForSuccessfulLoginHomePage();
        TimeUnit.SECONDS.sleep(2);
        objLoginPageBurger.sendInfoForExitUserToAccount();
        TimeUnit.SECONDS.sleep(2);
        String expected = "Войти";
        String actual = objLoginPageBurger.getTextForSuccessfulExitUser();
        assertEquals("Exit in login new user impossible",expected, actual);
    }
}