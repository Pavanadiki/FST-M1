package CRMActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {


    WebDriver Driver;

    @BeforeClass

    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        Driver = new FirefoxDriver();
        Driver.get("http://alchemy.hguy.co/crm");

    }

    @Test

    public void Footer() {

        String Pagefooter = Driver.findElement(By.id("admin_options")).getText();

        System.out.println("This is the first copyright text in the footer " + Pagefooter);


    }

    @AfterClass

    public void teardown() {
        Driver.quit();
    }


}
