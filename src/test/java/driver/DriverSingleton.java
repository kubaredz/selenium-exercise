package driver;

import driver.listeners.WebDriverEventListenerRegistrar;
import org.openqa.selenium.WebDriver;

import static properties.PropertiesReader.getTypeOfBrowser;
import static driver.BrowserFactory.chooseBrowserType;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton() {

    }

    public static WebDriver getDriver() {


        if (driver == null) {
            driver = chooseBrowserType(getTypeOfBrowser());
        }

        driver = WebDriverEventListenerRegistrar.registerWebDriverEventListener(driver);

        return driver;
    }

    public static void terminateDriver() {
        driver.close();
        driver.quit();
    }
}
