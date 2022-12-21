package burgertests;

import io.qameta.allure.junit4.DisplayName;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.RegistrationPageBurger;

import static org.junit.Assert.assertEquals;

public class RegistrationPageBurgerTest {
    WebDriver driver = new ChromeDriver();
    RegistrationPageBurger objRegistrationPageBurger = new RegistrationPageBurger(driver);
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

    @DisplayName("Create new default user")
    @Test
    public void shouldCreateNewDefaultUser() {
        objRegistrationPageBurger.sendInfoForNewDefaultUser();
        expected = "Войти";
        actual = objRegistrationPageBurger.getTextInfoSuccessfullyRegistration();
        assertEquals("Create new user impossible", expected, actual);
    }

    @DisplayName("Get error message to registration")
    @Test
    public void shouldInfoForErrorRegistration() {
        objRegistrationPageBurger.sendInfoForErrorRegistration();
        expected = "Некорректный пароль";
        actual = objRegistrationPageBurger.getTextInfoErrorRegistration();
        assertEquals("Create new user possible", expected, actual);
    }
}