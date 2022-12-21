package burgertests;

import io.qameta.allure.junit4.DisplayName;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.ConstructorPageBurger;
import pageobject.LoginPageBurger;
import pageobject.RegistrationPageBurger;

import static org.junit.Assert.assertEquals;

public class ConstructorPageBurgerTest {
    WebDriver driver = new ChromeDriver();
    LoginPageBurger objLoginPageBurger = new LoginPageBurger(driver);
    RegistrationPageBurger objRegistrationPageBurger = new RegistrationPageBurger(driver);
    ConstructorPageBurger objConstructorPageBurger = new ConstructorPageBurger(driver);
    String expected, actual;

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

    @DisplayName("Go from personal account to the constructor")
    @Test
    public void shouldGoAccountToConstructor() {
        objRegistrationPageBurger.sendInfoForSuccessfulRegistration();
        objLoginPageBurger.sendInfoForGoPersonalAccount();
        objConstructorPageBurger.goAccountToConstructor();
        expected = "Булки";
        actual = objConstructorPageBurger.getTextForSuccessfulGoConstructor();
        assertEquals("Go from personal account to the constructor impossible", expected, actual);
    }

    @DisplayName("Go from personal account to the logotype")
    @Test
    public void shouldGoAccountToLogotype() {
        objRegistrationPageBurger.sendInfoForSuccessfulRegistration();
        objLoginPageBurger.sendInfoForGoPersonalAccount();
        objConstructorPageBurger.goAccountToLogotype();
        expected = "Булки";
        actual = objConstructorPageBurger.getTextForSuccessfulGoConstructor();
        assertEquals("Go from personal account to the logotype impossible", expected, actual);
    }

    @DisplayName("Go from constructor to the Bun active")
    @Test
    public void shouldGoActiveBun() {
        objConstructorPageBurger.goActiveBun();
        expected = "Булки";
        actual = objConstructorPageBurger.getTextForSuccessfulGoSection();
        assertEquals("Bun active impossible", expected, actual);
    }

    @DisplayName("Go from constructor to the Sauce active")
    @Test
    public void shouldGoActiveSauce() {
        objConstructorPageBurger.goActiveSauce();
        expected = "Соусы";
        actual = objConstructorPageBurger.getTextForSuccessfulGoSection();
        assertEquals("Sauce active impossible", expected, actual);
    }

    @DisplayName("Go from constructor to the Filling active")
    @Test
    public void shouldGoActiveFilling() {
        objConstructorPageBurger.goActiveFilling();
        expected = "Начинки";
        actual = objConstructorPageBurger.getTextForSuccessfulGoSection();
        assertEquals("Filling active impossible", expected, actual);
    }
}