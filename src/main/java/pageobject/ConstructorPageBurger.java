package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ConstructorPageBurger {
    private WebDriver driver;
    private By constructor = By.xpath(".//header[@class='AppHeader_header__X9aJA pb-4 pt-4']//li[1]/a");
    private By logo = By.xpath(".//header[@class='AppHeader_header__X9aJA pb-4 pt-4']//div/a");
    private By bun = By.xpath(".//div[@style='display: flex;']/div[1]");
    private By sauce = By.xpath(".//div[@style='display: flex;']/div[2]");
    private By filling = By.xpath(".//div[@style='display: flex;']/div[3]");
    private By success = By.xpath(".//div[@style='display: flex;']/div[1]/span");
    private By section = By.cssSelector(".tab_tab__1SPyG.tab_tab_type_current__2BEPc .text");

    public ConstructorPageBurger(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Go from personal account to the constructor")
    public void goAccountToConstructor() {
        driver.findElement(constructor).click();
    }

    @Step("Go from personal account to the logotype")
    public void goAccountToLogotype() {
        driver.findElement(logo).click();
    }

    @Step("Massage for success contractor")
    public String getTextForSuccessfulGoConstructor() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(success)).getText();
    }

    @Step("Go from constructor to the bun")
    public void goActiveBun() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(sauce).click();
        driver.findElement(bun).click();
    }

    @Step("Go from constructor to the sauce")
    public void goActiveSauce() {
        driver.findElement(sauce).click();
    }

    @Step("Go from constructor to the filling")
    public void goActiveFilling() {
        driver.findElement(filling).click();
    }

    @Step("Massage for success section bun or sauce or filling")
    public String getTextForSuccessfulGoSection() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(section)).getText();
    }
}