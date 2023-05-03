package Steps;

import Pages.HomePage;
import Pages.VehicleAndTravelPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BelastingdienstHomeSteps {

    WebDriver driver = WebDriverManager.chromedriver().create();
    HomePage Home = new HomePage(driver);
    VehicleAndTravelPage Vehicle = new VehicleAndTravelPage(driver);
    @Given("I am on the Belastingdienst home page")
    public void iAmOnTheBelastingdienstHomePage() {
        Home.NavigateToWebsite();
    }

    @When("I click on the auto button on the main section")
    public void iClickOnTheAutoButtonOnTheMainSection() {
        Home.NavigateToAuto();
    }

    @Then("I should see the following header:")
    public void iShouldSeeTheFollowingHeader() {
        //Home.ValidatePageHeader();
        Vehicle.ValidatePageHeader();
    }
}
