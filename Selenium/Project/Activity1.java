package CRMActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver Driver;

    @BeforeClass

    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        Driver = new FirefoxDriver();
        Driver.get("http://alchemy.hguy.co/crm");

    }

    @Test

    public void title() {

        Driver.getTitle();
        System.out.println("Title is of this page is " + Driver.getTitle());
        Assert.assertEquals(Driver.getTitle(), "SuiteCRM");

    }

    @AfterClass

    public void teardown() {
        Driver.quit();
    }
}


