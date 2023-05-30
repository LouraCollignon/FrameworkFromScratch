package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

public class VehicleAndTravelPage {
    @FindBy(xpath = "//a[@class='bld-knop-algemeen']")
        WebElement GoToCalculateWegenbelasting;
    @FindBy(xpath = "//div[@id='bld-main-content']//h1" )
        WebElement AutoHeader;
    @FindBy(id = "butResults")
        WebElement CalculateBtn;
    @FindBy(xpath = "//label[@class='custom-control-label'][@for='V1-1_True']")
        WebElement nlJa;
    @FindBy(xpath = "//label[@class='custom-control-label'][@for='V1-1_False']")
    WebElement nlNee;
    @FindBy(xpath = "//select[@id='V1-2']")
    WebElement vehicleTypeDrpDwn;
    @FindBy(xpath = "//label[@class='custom-control-label'][@for='V1-16_True']")
    WebElement jaCleanEnergy;
    @FindBy(xpath = "//label[@class='custom-control-label'][@for='V1-16_False']")
    WebElement neeCleanEnergy;
    @FindBy(xpath = "//select[@id='V1-5']")
    WebElement chooseProvince;
    @FindBy(xpath = "//select[@id='V1-7']")
    WebElement chooseFuelType;
    @FindBy(xpath = "//select[@id='V1-9']")
    WebElement chooseWeightClass;
    @FindBy(xpath = "//div[@id='divResultTxt']/div/p")
    WebElement results;

    WebDriver driver;

    public void WaitForElementToLoad(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void ScrollIntoView(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", element);
    }
    public void GoToCalculator(){
        WaitForElementToLoad(GoToCalculateWegenbelasting);
        ScrollIntoView(GoToCalculateWegenbelasting);
        GoToCalculateWegenbelasting.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    public VehicleAndTravelPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void ValidatePageHeader(String headerText){
        ScrollIntoView(AutoHeader);
        WaitForElementToLoad(AutoHeader);
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String currentText = AutoHeader.getText();
        assertThat(headerText).isEqualTo(currentText);
    }
    public Boolean booleanValue(String value) {
        return Boolean.valueOf(value);
    }
    public void ClickCalculate(){
        CalculateBtn.click();
    }

    public void SelectInNetherlands(Boolean value) {
        if(value){
            nlJa.click();
        }
        else {
            nlNee.click();
        }
    }

    public void SelectVehicleType(String vehicleType){
        Select vehicleTypeOption = new Select(vehicleTypeDrpDwn);
        vehicleTypeOption.selectByVisibleText(vehicleType);
    }

    public void SelectCleanEnergy(Boolean value){
        if(value){
            jaCleanEnergy.click();
        }
        else {
            neeCleanEnergy.click();
        }
    }

    public void SelectProvince(String selectProvince){
        Select provinceOption = new Select(chooseProvince);
        provinceOption.selectByVisibleText(selectProvince);
    }

    public void SelectFuelType(String fuelType){
        Select chooseFuelOption = new Select(chooseFuelType);
        chooseFuelOption.selectByVisibleText(fuelType);
    }

    public void SelectWeightClass(String weightClass){
        Select weightClassOption = new Select(chooseWeightClass);
        weightClassOption.selectByVisibleText(weightClass);
    }

    public void CheckResults(){
        String resultsText = results.getText();
        assertThat(resultsText).isNotEmpty();
        System.out.println(resultsText);
    }
}
