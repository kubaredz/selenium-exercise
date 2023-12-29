package page;

import driver.DriverSingleton;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public abstract class BasePage {

    private Logger logger = Logger.getLogger(String.valueOf(BasePage.class));

    public BasePage() {
        PageFactory.initElements(DriverSingleton.getDriver(), this);
    }

    protected Logger log() {
        return logger;
    }
}