package nl.salves.testframework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public static WebDriver driver;
    public static WebDriver StartWebdriver(){
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        return driver;
    }

}
