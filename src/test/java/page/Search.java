package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import java.util.logging.Level;

public class Search extends BasePage {

    @FindBy(xpath = "//a[@class='gs-title']//b[text()='Google Cloud Pricing Calculator']")
    private WebElement googleCloudPricingCalculatorOption;

    @Step("Click google cloud pricing calculator option")
    public Calculator clickGoogleCloudPricingCalculatorOption() {
        WaitForElement.waitUntilElementIsVisible(googleCloudPricingCalculatorOption);
        googleCloudPricingCalculatorOption.click();
        log().log(Level.INFO, "googleCloudPricingCalculatorOption zostal wcisniety");
        return new Calculator();
    }
}