package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static helpers.ScreenshotManager.makeScreenShot;
import static properties.PropertiesReader.getPageUrl;
import static driver.DriverSingleton.*;

public class BaseTestNgSetup {

    @BeforeMethod
    public void beforeMethod() {
        getDriver().manage().window().maximize();
        getDriver().get(getPageUrl());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            makeScreenShot();
        }
        terminateDriver();
    }
}