package pageObject;

import lombok.SneakyThrows;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ConstructorPageBurgerTest {

    WebDriver driver = new ChromeDriver();
    LoginPageBurger objLoginPageBurger = new LoginPageBurger(driver);
    RegistrationPageBurger objRegistrationPageBurger = new RegistrationPageBurger(driver);
    ConstructorPageBurger objConstructorPageBurger = new ConstructorPageBurger(driver);

    @Before
    public void setUp() {
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @SneakyThrows
    @DisplayName("Go from personal account to the constructor")
    @Test
    public void shouldGoAccountToConstructor() {
        objRegistrationPageBurger.sendInfoForSuccessfulRegistration();
        TimeUnit.SECONDS.sleep(2);
        objLoginPageBurger.sendInfoForGoPersonalAccount();
        TimeUnit.SECONDS.sleep(2);
        objConstructorPageBurger.goAccountToConstructor();
        String expected = "Булки";
        String actual = objConstructorPageBurger.getTextForSuccessfulGoConstructor();
        assertEquals("Go from personal account to the constructor impossible",expected, actual);
    }

    @SneakyThrows
    @DisplayName("Go from personal account to the logotype")
    @Test
    public void shouldGoAccountToLogotype() {
        objRegistrationPageBurger.sendInfoForSuccessfulRegistration();
        TimeUnit.SECONDS.sleep(2);
        objLoginPageBurger.sendInfoForGoPersonalAccount();
        TimeUnit.SECONDS.sleep(2);
        objConstructorPageBurger.goAccountToLogotype();
        String expected = "Булки";
        String actual = objConstructorPageBurger.getTextForSuccessfulGoConstructor();
        assertEquals("Go from personal account to the logotype impossible",expected, actual);
    }

    @SneakyThrows
    @DisplayName("Go from constructor to the Bun active")
    @Test
    public void shouldGoActiveBun() {
        TimeUnit.SECONDS.sleep(2);
        objConstructorPageBurger.goActiveBun();
        TimeUnit.SECONDS.sleep(2);
        String expected = "Булки";
        String actual = objConstructorPageBurger.getTextForSuccessfulGoSection();
        assertEquals("Bun active impossible",expected, actual);
    }

    @SneakyThrows
    @DisplayName("Go from constructor to the Sauce active")
    @Test
    public void shouldGoActiveSauce() {
        TimeUnit.SECONDS.sleep(2);
        objConstructorPageBurger.goActiveSauce();
        TimeUnit.SECONDS.sleep(2);
        String expected = "Соусы";
        String actual = objConstructorPageBurger.getTextForSuccessfulGoSection();
        assertEquals("Sauce active impossible",expected, actual);
    }

    @SneakyThrows
    @DisplayName("Go from constructor to the Filling active")
    @Test
    public void shouldGoActiveFilling() {
        TimeUnit.SECONDS.sleep(2);
        objConstructorPageBurger.goActiveFilling();
        TimeUnit.SECONDS.sleep(2);
        String expected = "Начинки";
        String actual = objConstructorPageBurger.getTextForSuccessfulGoSection();
        assertEquals("Filling active impossible",expected, actual);
    }
}