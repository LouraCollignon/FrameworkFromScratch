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
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", element);
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
