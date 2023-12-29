package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.Calculator;
import page.Cookies;
import page.EmailEstimate;
import page.yopmail.YopMail;
import utils.testng.listeners.RetryAnalyzer;

import static helpers.MovingThroughTabs.*;
import static properties.PropertiesReader.*;
import static driver.DriverSingleton.getDriver;

public class ProcessOfRegisteringCloudPlatformTests extends BaseTestNgSetup {

    @Test()
    @Issue("DEFECT-1")
    @TmsLink("KP-T2")
    @Parameters("productName")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Process of registering cloud platform which is 'Compute Engine' with email price verification")
    public void automateProcessOfRegisteringCloudPlatformPricingCalculator(@Optional("Google Cloud Platform Pricing Calculator") String productName) {
        Cookies cookies = new Cookies();
        cookies
                .clickAcceptCookiesButton()
                .clickSearchIcon()
                .setTextInSearchInput(productName)
                .clickGoogleCloudPricingCalculatorOption()
                .clickComputeEngineSection()
                .setNumberOfInstances(getNumberOfInstances())
                .setInstancesReasonInput(getInstancesReasonInput())
//                .clickOperatingSystemSelect()
//                .setOperatingSystem()
//                .clickProvisioningModelSelect()
//                .setProvisioningModel(getProvisioningModel())
                .clickMachineFamilySelect()
                .setMachineFamily(getMachineFamily())
                .clickSeriesSelect()
                .setSeries(getSeries())
//                .clickMachineTypeSelect()
//                .setMachineType(getMachineType())
                .clickAddGpuCheckbox()
                .clickGpuTypeSelect()
                .setGpuType(getGpuType())
//                .clickNumberOfGpuSelect()
//                .setNumberOfGpu(getNumberOfCpu())
//                .clickLocalSsdSelect()
//                .setLocalSsd(getLocalSsd())
//                .clickDatacenterLocationSelect()
//                .setDatacenterLocation(getDataCenterLocation())
//                .clickCommittedUsageSelect()
//                .setCommittedUsage(getCommittedUsage())
                .clickAddToEstimateButton()
                .assertThatEstimatedCostIsCorrect()
                .clickEmailEstimate();

        openNewTab();
        switchToNewTab();

        getDriver().get("https://yopmail.com/pl/");

        YopMail yopMail = new YopMail();
        yopMail
                .clickAcceptRecommendedCookies()
                .clickGenerateRandomEmail();

        String generatedEmail = yopMail.getGeneratedRandomEmail();
        yopMail.clickCheckEmailButton();

        switchBackToPreviousTab();

        EmailEstimate emailEstimate = new EmailEstimate();
        emailEstimate
                .setEmailLabel(generatedEmail)
                .clickSendEmailButton();

        switchBackToPreviousTab();

        yopMail
                .clickRefreshButton()
                .assertThatEstimatedCostIsCorrectInMail();
    }
}