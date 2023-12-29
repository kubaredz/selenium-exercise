package page;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import java.util.logging.Level;

import static driver.DriverSingleton.getDriver;

public class Homepage extends BasePage {

    @FindBy(xpath = "//div[@class='YSM5S']")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[@class='mb2a7b']")
    private WebElement searchInput;

    public Homepage() {
        PageFactory.initElements(getDriver(), this);
    }

    public Homepage clickSearchIcon() {
        WaitForElement.waitUntilElementIsVisible(searchIcon);
        searchIcon.click();
        log().log(Level.INFO, "searchIcon zostal wcisniety");
        return this;
    }

    @Step("Set search input text: {text}")
    public Search setTextInSearchInput(String text) {
        WaitForElement.waitUntilElementIsVisible(searchInput);
        searchInput.sendKeys(text + Keys.ENTER);
        log().log(Level.INFO, "searchInput zostal ustawiony wartoscia: {0}", text);
        return new Search();
    }
}