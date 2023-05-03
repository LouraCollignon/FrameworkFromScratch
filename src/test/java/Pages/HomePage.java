package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;

    By AutoBtn = By.xpath("//span[contains(text(), 'auto')]");
    By AutoHeader = By.xpath("//header//h1");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void NavigateToWebsite(){
        String url = "https://www.belastingdienst.nl/";
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }
    public void NavigateToAuto(){
        driver.findElement(AutoBtn).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void ValidatePageHeader(){
        String actualText = "Auto en woon-werkverkeer";
        String headerText = driver.findElement(AutoHeader).getText();
        actualText.equals(headerText);
    }
}
