package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VehicleAndTravelPage {
    WebDriver driver;
    By AutoHeader = By.xpath("//header//h1");

    public VehicleAndTravelPage(WebDriver driver){
        this.driver = driver;
    }

    public void ValidatePageHeader(){
        String actualText = "Auto en woon-werkverkeer";
        String headerText = driver.findElement(AutoHeader).getText();
        actualText.equals(headerText);
    }
}
