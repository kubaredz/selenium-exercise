package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.logging.Level;


public class Cookies extends BasePage {

    @FindBy(xpath = "//button[@class='pvUife']")
    private WebElement acceptCookiesButton;

    @Step("Click accept cookies button")
    public Homepage clickAcceptCookiesButton() {
        WaitForElement.waitUntilElementIsVisible(acceptCookiesButton);
        acceptCookiesButton.click();
        log().log(Level.INFO, "acceptCookiesButton zostal wcisniety");
        return new Homepage();
    }
}