import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class example {

    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.chromedriver().create();
        String url = "https://www.belastingdienst.nl/wps/wcm/connect/nl/auto-en-vervoer/content/hulpmiddel-motorrijtuigenbelasting-berekenen";
        driver.navigate().to(url);
        driver.manage().window().maximize();

        //click around
        WebElement startBerekening = driver.findElement(By.xpath("//div[@class='bld-form']"));
        Actions action = new Actions(driver);
        action.moveToElement(startBerekening);
        action.perform();
        WebElement nlJa = driver.findElement(By.xpath("//label[@class='custom-control-label'][@for='V1-1_True']"));
        nlJa.click();
        WebElement soortVoertuigdrpdwn = driver.findElement(By.xpath("//select[@id='V1-2']"));
        Select soortVoertuig = new Select(soortVoertuigdrpdwn);
        soortVoertuig.selectByVisibleText("Personenauto");
        WebElement elecOfWaterJa = driver.findElement(By.xpath("//label[@class='custom-control-label'][@for='V1-16_True']"));
        elecOfWaterJa.click();
        WebElement resultsBtn = driver.findElement(By.xpath("//button[@id='butResults']"));
        resultsBtn.click();
        //validate result
        WebElement results = driver.findElement(By.xpath("//div[@id='divResultTxt']/div/p"));
        String resultText = results.getText();
        System.out.println(resultText);
        //start again with next test
        driver.navigate().to(url);
        WebElement startBerekening2 = driver.findElement(By.xpath("//div[@class='bld-form']"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(startBerekening2);
        action2.perform();
        WebElement nlJa2 = driver.findElement(By.xpath("//label[@class='custom-control-label'][@for='V1-1_True']"));
        nlJa2.click();
        WebElement soortVoertuigdrpdwn2 = driver.findElement(By.xpath("//select[@id='V1-2']"));
        Select soortVoertuig2 = new Select(soortVoertuigdrpdwn2);
        soortVoertuig2.selectByVisibleText("Personenauto");
        WebElement elecOfWaterNee = driver.findElement(By.xpath("//label[@class='custom-control-label'][@for='V1-16_False']"));
        elecOfWaterNee.click();
        WebElement kiesProvincie = driver.findElement(By.xpath("//select[@id='V1-5']"));
        Select provincie = new Select(kiesProvincie);
        provincie.selectByVisibleText("Noord-Brabant");
        WebElement kiesBrandstof = driver.findElement(By.xpath("//select[@id='V1-7']"));
        Select brandstof = new Select(kiesBrandstof);
        brandstof.selectByVisibleText("Benzine");
        WebElement kiesGewichtsKlasse = driver.findElement(By.xpath("//select[@id='V1-9']"));
        Select gewichtsKlasse = new Select(kiesGewichtsKlasse);
        gewichtsKlasse.selectByVisibleText("3351 t/m 3450");
        WebElement resultsBtn2 = driver.findElement(By.xpath("//button[@id='butResults']"));
        resultsBtn2.click();
        //validate results
        WebElement results2 = driver.findElement(By.xpath("//div[@id='divResultTxt']/div/p"));
        String results2Text = results2.getText();
        System.out.println(results2Text);
        //start again with a new test
        driver.navigate().to(url);
        WebElement startBerekening3 = driver.findElement(By.xpath("//div[@class='bld-form']"));
        Actions action3 = new Actions(driver);
        action3.moveToElement(startBerekening3);
        action3.perform();
        WebElement nlJa3 = driver.findElement(By.xpath("//label[@class='custom-control-label'][@for='V1-1_True']"));
        nlJa3.click();
        WebElement soortVoertuigdrpdwn3 = driver.findElement(By.xpath("//select[@id='V1-2']"));
        Select soortVoertuig3 = new Select(soortVoertuigdrpdwn3);
        soortVoertuig3.selectByVisibleText("Motor");
        WebElement elecOfWaterNee2 = driver.findElement(By.xpath("//label[@class='custom-control-label'][@for='V1-16_False']"));
        elecOfWaterNee2.click();
        WebElement kiesProvincie2 = driver.findElement(By.xpath("//select[@id='V1-5']"));
        Select provincie2 = new Select(kiesProvincie2);
        provincie2.selectByVisibleText("Drenthe");
        WebElement resultsBtn3 = driver.findElement(By.xpath("//button[@id='butResults']"));
        resultsBtn3.click();
        //validate results
        WebElement results3 = driver.findElement(By.xpath("//div[@id='divResultTxt']/div/p"));
        String results3Text = results3.getText();
        System.out.println(results3Text);
    }
}
