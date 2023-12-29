package page;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import properties.PropertiesReader;
import waits.WaitForElement;

import java.util.logging.Level;

import static helpers.MovingThroughTabs.changeNestedFrame;
import static driver.DriverSingleton.getDriver;

public class Calculator extends BasePage {

    @FindBy(xpath = "//*[@title='Compute Engine']")
    private WebElement computeEngineSection;

    @FindBy(xpath = "//*[@name='quantity']")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement instancesReasonInput;

    @FindBy(xpath = "//*[@id='select_value_label_93']")
    private WebElement operatingSystemSelect;

    @FindBy(xpath = "//md-option[@id='select_option_102']")
    private WebElement pickFreeOperatingSystemOption;

    @FindBy(xpath = "//*[@id=select_option_115]")
    private WebElement provisioningModelSelect;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_95']")
    private WebElement machineFamilySelect;

    @FindBy(xpath = "//*[@id='select_value_label_96']")
    private WebElement seriesSelect;

    @FindBy(xpath = "//*[@id='select_value_label_97']")
    private WebElement machineTypeSelect;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGpuCheckbox;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement gpuTypeSelect;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numberOfGpuSelect;

    @FindBy(xpath = "//*[@id='select_value_label_467']")
    private WebElement localSsdSelect;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_99']")
    private WebElement datacenterLocationSelect;

    @FindBy(xpath = "//*[@id='select_value_label_100']")
    private WebElement committedUsageSelect;

    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//h2[@ng-if='appCtrl.CartData.hasItems()']")
    private WebElement estimatePrice;

    @FindBy(xpath = "//*[@id='resultBlock']/md-card/md-card-content/div/div/div/div[1]/h2/b")
    private WebElement totalEstimatedCostText;

    @FindBy(xpath = "//*[@id='Email Estimate']")
    private WebElement emailIcon;

    @FindBy
    private WebElement provisioningModelOption;

    @FindBy
    private WebElement machineFamilyOption;

    @FindBy
    private WebElement seriesOption;

    @FindBy
    private WebElement machineTypeOption;

    @FindBy
    private WebElement gpuTypeOption;

    @FindBy
    private WebElement numberOfGpuOption;

    @FindBy
    private WebElement localSsdOption;

    @FindBy
    private WebElement datacenterLocationOption;

    @FindBy
    private WebElement committedUsageOption;

    public Calculator clickComputeEngineSection() {
        changeNestedFrame(0, 0);
        WaitForElement.waitUntilElementIsVisible(computeEngineSection);
        computeEngineSection.click();
        log().log(Level.INFO, "computeEngineSection zostal wcisniety");
        return this;
    }

    @Step("Pick number of instances: {numberOfInstances}")
    public Calculator setNumberOfInstances(String numberOfInstances) {
        numberOfInstancesInput.sendKeys(numberOfInstances);
        log().log(Level.INFO, "numberOfInstancesInput zostal ustawiony wartoscia: {0}", numberOfInstances);
        return this;
    }

    @Step("Pick instances reason: {instancesReason}")
    public Calculator setInstancesReasonInput(String instancesReason) {
        instancesReasonInput.sendKeys(instancesReason);
        log().log(Level.INFO, "instancesReasonInput zostal ustawiony wartoscia: {0}", instancesReason);
        return this;
    }

    @Step("Click operating system select")
    public Calculator clickOperatingSystemSelect() {
        operatingSystemSelect.click();
        log().log(Level.INFO, "operatingSystemSelect zostal wcisniety");
        return this;
    }

    @Step("Click free operating system select")
    public Calculator clickFreeOperatingSystem() {
        pickFreeOperatingSystemOption.click();
        log().log(Level.INFO, "pickFreeOperatingSystemOption zostal wcisniety");
        return this;
    }

    @Step("Click provisioning model select")
    public Calculator clickProvisioningModelSelect() {
        provisioningModelSelect.click();
        log().log(Level.INFO, "provisioningModelSelect zostal wcisniety");
        return this;
    }

    @Step("Pick provisioning model: {provisioningModel}")
    public Calculator setProvisioningModel(String provisioningModel) {
        provisioningModelOption = getDriver().findElement(By.xpath("//div[@class='md-text' and contains(text(), '" + provisioningModel + "')]"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", provisioningModelOption);
        log().log(Level.INFO, "provisioningModelOption zostal ustawiony wartoscia: {0}", provisioningModel);
        return this;
    }

    @Step("Click machine family select")
    public Calculator clickMachineFamilySelect() {
        machineFamilySelect.click();
        log().log(Level.INFO, "machineFamilySelect zostal wcisniety");
        return this;
    }

    @Step("Pick machine family: {machineFamily}")
    public Calculator setMachineFamily(String machineFamily) {
        machineFamilyOption = getDriver().findElement(By.xpath("//div[@class='md-text' and contains(text(), '" + machineFamily + "')]"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", machineFamilyOption);
        log().log(Level.INFO, "machineFamilyOption zostal ustawiony wartoscia: {0}", machineFamily);
        return this;
    }

    @Step("Click series select")
    public Calculator clickSeriesSelect() {
        seriesSelect.click();
        log().log(Level.INFO, "seriesSelect zostal wcisniety");
        return this;
    }

    @Step("Pick series: {series}")
    public Calculator setSeries(String series) {
        seriesOption = getDriver().findElement(By.xpath("//div[@class='md-text ng-binding' and contains(text(), '" + series + "')]"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", seriesOption);
        log().log(Level.INFO, "seriesOption zostal ustawiony wartoscia: {0}", series);
        return this;
    }

    @Step("Click machine type select")
    public Calculator clickMachineTypeSelect() {
        machineTypeSelect.click();
        log().log(Level.INFO, "machineTypeSelect zostal wcisniety");
        return this;
    }

    @Step("Pick machine type {machineType}")
    public Calculator setMachineType(String machineType) {
        machineTypeOption = getDriver().findElement(By.xpath("//div[@class='md-text ng-binding' and contains(text(), '" + machineType + "')]"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", machineTypeOption);
        log().log(Level.INFO, "machineTypeOption zostal ustawiony wartoscia: {0}", machineType);
        machineTypeOption.click();
        return this;
    }

    @Step("Click add gpu checkbox")
    public Calculator clickAddGpuCheckbox() {
        addGpuCheckbox.click();
        log().log(Level.INFO, "addGpuCheckbox zostal wcisniety");
        return this;
    }

    @Step("Click gpu type select")
    public Calculator clickGpuTypeSelect() {
        gpuTypeSelect.click();
        log().log(Level.INFO, "gpuTypeSelect zostal wcisniety");
        return this;
    }

    @Step("Pick gpu type: {gpuType}")
    public Calculator setGpuType(String gpuType) {
        gpuTypeOption = getDriver().findElement(By.xpath("//md-option[contains(@ng-repeat, 'item in listingCtrl.gpuList') and @value='" + gpuType + "']"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", gpuTypeOption);
        log().log(Level.INFO, "gpuTypeOption zostal ustawiony wartoscia: {0}", gpuType);
        return this;
    }

    @Step("Click number of gpu select")
    public Calculator clickNumberOfGpuSelect() {
        numberOfGpuSelect.click();
        log().log(Level.INFO, "numberOfGpuSelect zostal wcisniety");
        return this;
    }

    @Step("Pick number of gpu: {numberOfGpu}")
    public Calculator setNumberOfGpu(String numberOfGpu) {
        numberOfGpuOption = getDriver().findElement(By.xpath("//div[@class='md-text ng-binding' and normalize-space(text())='" + numberOfGpu + "']"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", numberOfGpuOption);
        numberOfGpuOption.click();
        log().log(Level.INFO, "numberOfGpuOption zostal ustawiony wartoscia: {0}", numberOfGpu);
        return this;
    }

    @Step("Click local ssd select")
    public Calculator clickLocalSsdSelect() {
        localSsdSelect.click();
        log().log(Level.INFO, "localSsdSelect zostal wcisniety");
        return this;
    }

    @Step("pick local ssd: {localSsd}")
    public Calculator setLocalSsd(String localSsd) {
        localSsdOption = getDriver().findElement(By.xpath("//div[@class='md-text ng-binding' and normalize-space(text())='" + localSsd + "']"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", localSsdOption);
        log().log(Level.INFO, "localSsdOption zostal ustawiony wartoscia: {0}", localSsd);
        return this;
    }

    @Step("Click data center location select")
    public Calculator clickDatacenterLocationSelect() {
        datacenterLocationSelect.click();
        log().log(Level.INFO, "datacenterLocationSelect zostal wcisniety");
        return this;
    }

    @Step("Pick data center location: {datacenterLocation}")
    public Calculator setDatacenterLocation(String datacenterLocation) {
        datacenterLocationOption = getDriver().findElement(By.xpath("//md-option[contains(@ng-repeat, 'item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer') and @value='" + datacenterLocation + "']"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", datacenterLocationOption);
        datacenterLocationOption.click();
        log().log(Level.INFO, "datacenterLocationOption zostal ustawiony wartoscia: {0}", datacenterLocation);
        return this;
    }

    @Step("Click committed usage select")
    public Calculator clickCommittedUsageSelect() {
        committedUsageSelect.click();
        log().log(Level.INFO, "committedUsageSelect zostal wcisniety");
        return this;
    }

    @Step("Pick committed usag: {committedUsage}")
    public Calculator setCommittedUsage(String committedUsage) {
        committedUsageOption = getDriver().findElement(By.xpath("//div[@class='md-text' and contains(text(), '" + committedUsage + "')]"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", committedUsageOption);
        committedUsageOption.click();
        log().log(Level.INFO, "committedUsageOption zostal ustawiony wartoscia: {0}", committedUsage);
        return this;
    }

    @Step("Click add to estimate button")
    public Calculator clickAddToEstimateButton() {
        addToEstimateButton.click();
        log().log(Level.INFO, "addToEstimateButton zostal wcisniety");
        return this;
    }

    @Step("Get total estimated price")
    public Calculator assertThatEstimatedCostIsCorrect() {
        WaitForElement.waitUntilElementIsVisible(totalEstimatedCostText);
        log().log(Level.INFO, "Checing if totalEstimatedCost value is equal expected value: {}", totalEstimatedCostText.getText());
        AssertWebElement.assertThat(totalEstimatedCostText).hasText(PropertiesReader.getFinalPrice());
        return this;
    }

    @Step("Click email estimate icon")
    public Calculator clickEmailEstimate() {
        WaitForElement.waitUntilElementIsClickable(emailIcon);
        emailIcon.click();
        log().log(Level.INFO, "emailIcon zostal wcisniety");
        return this;
    }
}