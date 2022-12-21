package burgertests;

import io.qameta.allure.junit4.DisplayName;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.LoginPageBurger;
import pageobject.RegistrationPageBurger;

import static org.junit.Assert.assertEquals;

public class LoginPageBurgerTest {
    WebDriver driver = new ChromeDriver();
    LoginPageBurger objLoginPageBurger = new LoginPageBurger(driver);
    RegistrationPageBurger objRegistrationPageBurger = new RegistrationPageBurger(driver);
    String expected, actual;

    @SneakyThrows
    @Before
    public void setUp() {
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void tearDown() {
        driver.quit();
        expected = "";
        actual = "";
    }

    @DisplayName("Login new default user to registration form")
    @Test
    public void shouldSuccessfulLoginRegistrationForm() {
        objRegistrationPageBurger.sendInfoForSuccessfulRegistration();
        objLoginPageBurger.sendInfoForSuccessfulLoginRegistrationForm();
        expected = "Оформить заказ";
        actual = objLoginPageBurger.getTextForSuccessfulLogin();
        assertEquals("Login new user impossible", expected, actual);
    }

    @DisplayName("Login new default user to login account")
    @Test
    public void shouldSuccessfulLoginAccount() {
        objRegistrationPageBurger.sendInfoForSuccessfulRegistration();
        objLoginPageBurger.sendInfoForSuccessfulLoginAccount();
        expected = "Оформить заказ";
        actual = objLoginPageBurger.getTextForSuccessfulLogin();
        assertEquals("Login new user impossible", expected, actual);
    }

    @DisplayName("Login new default user to HomePage")
    @Test
    public void shouldSuccessfulLoginHomePage() {
        objLoginPageBurger.sendInfoForSuccessfulLoginHomePage();
        expected = "Оформить заказ";
        actual = objLoginPageBurger.getTextForSuccessfulLogin();
        assertEquals("Login new user impossible", expected, actual);
    }

    @DisplayName("Login new default user to forgot password form")
    @Test
    public void shouldSuccessfulLoginForgotPasswordForm() {
        objRegistrationPageBurger.sendInfoForSuccessfulRegistration();
        objLoginPageBurger.sendInfoForSuccessfulLoginForgotPasswordForm();
        expected = "Оформить заказ";
        actual = objLoginPageBurger.getTextForSuccessfulLogin();
        assertEquals("Login new user impossible", expected, actual);
    }

    @DisplayName("Exit new default user to account")
    @Test
    public void shouldSuccessfulExitUserToAccount() {
        objLoginPageBurger.sendInfoForSuccessfulLoginHomePage();
        objLoginPageBurger.sendInfoForExitUserToAccount();
        expected = "Войти";
        actual = objLoginPageBurger.getTextForSuccessfulExitUser();
        assertEquals("Exit in login new user impossible", expected, actual);
    }
}