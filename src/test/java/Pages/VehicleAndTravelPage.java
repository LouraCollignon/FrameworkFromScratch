package Pages;

import io.cucumber.messages.types.Exception;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VehicleAndTravelPage {
    WebDriver driver;
    By AutoHeader = By.xpath("//header//h1");

    public VehicleAndTravelPage(WebDriver driver){
        this.driver = driver;
    }

    public void ValidatePageHeader(){
        String actualText = "Auto en woon-werkverkeer";
        String headerText = driver.findElement(AutoHeader).getText();
        Boolean result = actualText.equals(headerText);
        if(result == false){
            //fail the test.
        }
    }
}
