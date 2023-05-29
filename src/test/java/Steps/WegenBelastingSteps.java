package Steps;

import Pages.HomePage;
import Pages.VehicleAndTravelPage;
import io.cucumber.java.en.*;
import nl.salves.testframework.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class WegenBelastingSteps {
    //I did this, but why does it work?
    WebDriver driver = WebDriverFactory.StartWebdriver();
    HomePage HomePage = new HomePage(driver);
    VehicleAndTravelPage Vehicle = new VehicleAndTravelPage(driver);
    String BelastingdienstHomePage = "https://www.belastingdienst.nl/wps/wcm/connect/nl/home/home";


    /*@Before
    public void StartTest(){
        WebDriver driver = WebDriverFactory.StartWebdriver();
        driver.manage().window().maximize();
    }*/

    /*@After
    public void CleanUpTest(){
    //maybe take a screenshot of last page (whether success or failure)
        driver.close();
        driver.quit();
    }*/

    //scenario 1
    @Given("That I am on the Wegenbelasting Home page")
    public void thatIAmOnTheWegenbelastingHomePage() {
        driver.navigate().to(BelastingdienstHomePage);
    }
    @When("I surf to the Wegenbelasting calculation page")
    public void iSurfToTheWegenbelastingCalculationPage() {
        HomePage.NavigateToWegenbelastingBerekenen();
        Vehicle.GoToCalculator();
    }
    @Then("I should see the header: {string}")
    public void iShouldSeeTheHeader(String headerText) {
        Vehicle.ValidatePageHeader(headerText);
    }

    //scenario 2
    @Given("I am on the Wegenbelasting calculation page and see {string}")
    public void iAmOnTheWegenbelastingCalculationPageAndSee(String headerText) {
        driver.navigate().to(BelastingdienstHomePage);
        HomePage.NavigateToWegenbelastingBerekenen();
        Vehicle.ValidatePageHeader(headerText);
    }

    @When("I select if I live in the Netherlands {string}")
    public void iSelectIfILiveInTheNetherlands(String LiveInNl) {
        Boolean value = Vehicle.booleanValue(LiveInNl);
        Vehicle.SelectInNetherlands(value);
    }
    //weird that parameter string misses from method name?
    @And("I select the {string} that I own")
    public void iSelectTheThatIOwn(String vehicleType) {
        Vehicle.SelectVehicleType(vehicleType);
    }

    @And("I select whether my car drives on {string}")
    public void iSelectWhetherMyCarDrivesOn(String cleanEnergy) {
        Boolean value = Vehicle.booleanValue(cleanEnergy);
        Vehicle.SelectCleanEnergy(value);
    }

    @And("I select what {string} I live in")
    public void iSelectWhatILiveIn(String province) {
        Vehicle.SelectProvince(province);
    }

    @And("I select what {string} my car has")
    public void iSelectWhatMyCarHas(String fuelType) {
        Vehicle.SelectFuelType(fuelType);
    }

    @And("I select what {string} my car belongs into")
    public void iSelectWhatMyCarBelongsInto(String weightClass) {
        Vehicle.SelectWeightClass(weightClass);
    }

    @And("I click the calculate button")
    public void iClickTheCalculateButton() {
        Vehicle.ClickCalculate();
    }

    @Then("I should be seeing the amount of taxes I need to pay for the car options I put in.")
    public void iShouldBeSeeingTheAmountOfTaxesINeedToPayForTheCarOptionsIPutIn() {
        Vehicle.CheckResults();
    }


}
