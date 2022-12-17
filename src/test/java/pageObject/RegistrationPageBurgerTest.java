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

public class RegistrationPageBurgerTest {
    WebDriver driver = new ChromeDriver();
    RegistrationPageBurger objRegistrationPageBurger = new RegistrationPageBurger(driver);

    @Before
    public void setUp() {
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @SneakyThrows
    @DisplayName("Create new default user")
    @Test
    public void shouldCreateNewDefaultUser() {
        objRegistrationPageBurger.sendInfoForNewDefaultUser();
        TimeUnit.SECONDS.sleep(2); // без этой задержки не видит кнопку войти
        String expected = "Войти";
        String actual = objRegistrationPageBurger.getTextInfoSuccessfullyRegistration();
        assertEquals("Create new user impossible",expected, actual);
    }

    @DisplayName("Get error message to registration")
    @Test
    public void shouldInfoForErrorRegistration() {
        objRegistrationPageBurger.sendInfoForErrorRegistration();
        String expected = "Некорректный пароль";
        String actual = objRegistrationPageBurger.getTextInfoErrorRegistration();
        assertEquals("Create new user possible",expected, actual);
    }
}
