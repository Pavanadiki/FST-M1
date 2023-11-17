package CRMActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver Driver;

    @BeforeClass

    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        Driver = new FirefoxDriver();
        Driver.get("http://alchemy.hguy.co/crm");

    }

    @Test

    public void Heading() {

        String heading1 = Driver.findElement(By.cssSelector("#form > div.companylogo > img")).getAttribute("src");
        System.out.println("This image URl of the SuiteCRM is " + heading1);


    }

    @AfterClass

    public void teardown() {
        Driver.quit();
    }



}
