package generic.assertions;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;


public class AssertWebElement extends AbstractAssert<AssertWebElement, WebElement> {

    private Logger logger = Logger.getLogger(String.valueOf(AssertWebElement.class));

    public AssertWebElement(WebElement element) {
        super(element, AssertWebElement.class);
    }

    public static AssertWebElement assertThat(WebElement webElement){
        return new AssertWebElement(webElement);
    }

    //Metoda do sprawdzania czy element jest wyświetlony
    public AssertWebElement isDisplayed(){
        logger.info("Checking if element is displayed");
        isNotNull();

        if(!actual.isDisplayed()){
            failWithMessage("Element was not displayed!");
        }
        logger.info("WebElement was displayed!");
        return this;
    }

//    /Metoda do sprawdzenia czy element posiada zadany tekst
    public AssertWebElement hasText(String expectedTextValue){
        logger.info("Checking if WebElement has text: " + expectedTextValue);
        isNotNull();

        String actualElementText = actual.getText();
        if(!actualElementText.equals(expectedTextValue)){
            failWithMessage("Element text was <%s> expecting to be <%s>!", actualElementText, expectedTextValue);
        }

        logger.info("WebElement had expected text!");
        return this;
    }
}
