package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[contains(text(), 'auto')]")
        WebElement AutoBtn;

    public void ScrollIntoView(WebElement element) {
        /*Integer Y_movement = 200;
        Integer elementLocation = element.getLocation().getY();
        int moveYAxis = elementLocation-Y_movement;
        String strLocation = String.format("arguments[0].scrollIntoView(true); window.scrollBy(0, %s;)", moveYAxis);*/
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void JSClick (WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }
    public void NavigateToWegenbelastingBerekenen() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ScrollIntoView(AutoBtn);
        //why are you throwing an error when clicking?
        //AutoBtn.click();
        JSClick(AutoBtn);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
