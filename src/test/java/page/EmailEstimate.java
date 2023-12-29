package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.logging.Level;

import static helpers.MovingThroughTabs.changeNestedFrame;

public class EmailEstimate extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailLabel;

    @FindBy(xpath = "//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement sendEmailButton;

    @Step("Set email label: {email}")
    public EmailEstimate setEmailLabel(String email) {
        changeNestedFrame(0, 0);
        WaitForElement.waitUntilElementIsVisible(emailLabel);
        emailLabel.sendKeys(email);
        log().log(Level.INFO, "emailLabel zostal ustawiony wartoscia: {0}", email);
        return this;
    }

    @Step("Click send email button")
    public EmailEstimate clickSendEmailButton() {
        sendEmailButton.click();
        log().log(Level.INFO, "sendEmailButton zostal wcisniety");
        return this;
    }
}