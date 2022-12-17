package pageObject;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationPageBurger {
    private WebDriver driver;
    private static Faker faker = new Faker(new Locale("en"));
    private By account = By.xpath(".//a[@href='/account']");
    private By register = By.xpath(".//a[@href='/register']");

    private By name = By.xpath(".//form[@class='Auth_form__3qKeq mb-20']/fieldset[1]//input");
    private By email = By.xpath(".//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]//input");
    private By password = By.xpath(".//form[@class='Auth_form__3qKeq mb-20']/fieldset[3]//input");
    private By registration = By.xpath(".//form[@class='Auth_form__3qKeq mb-20']/button");

    private By registrationOk = By.xpath(".//div[@class='Auth_login__3hAey']//button");
    private By error = By.cssSelector(".input__error.text_type_main-default");


    public RegistrationPageBurger(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Send info to create new default user")
    public void sendInfoForNewDefaultUser() {
        driver.findElement(account).click();
        driver.findElement(register).click();
        driver.findElement(name).sendKeys(faker.name().fullName());
        driver.findElement(email).sendKeys(faker.name().firstName() + faker.numerify("###") + "@mail.ru");
        driver.findElement(password).sendKeys(faker.numerify("#######"));
        driver.findElement(registration).click();
    }

    @Step("Send info to successful registration")
    public void sendInfoForSuccessfulRegistration() {
        driver.findElement(account).click();
        driver.findElement(register).click();
        driver.findElement(name).sendKeys(RandomInfo.RANDOM_NAME);
        driver.findElement(email).sendKeys(RandomInfo.RANDOM_EMAIL);
        driver.findElement(password).sendKeys(RandomInfo.RANDOM_PASSWORD);
        driver.findElement(registration).click();
    }


    @Step("Massage for success registration")
    public String getTextInfoSuccessfullyRegistration() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(registrationOk)).getText();
    }

    @Step("Send info to create new user with error password")
    public void sendInfoForErrorRegistration() {
        driver.findElement(account).click();
        driver.findElement(register).click();
        driver.findElement(name).sendKeys(faker.name().fullName());
        driver.findElement(email).sendKeys(faker.name().firstName() + faker.numerify("###") + "@mail.ru");
        driver.findElement(password).sendKeys(faker.numerify("#####"));
        driver.findElement(registration).click();
    }

    @Step("Massage for error to registration")
    public String getTextInfoErrorRegistration() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(error)).getText();
    }
}
