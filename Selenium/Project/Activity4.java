package CRMActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {


    WebDriver Driver;

    @BeforeClass

    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        Driver = new FirefoxDriver();
        Driver.get("http://alchemy.hguy.co/crm");

    }

    @Test

    public void Login() {

        WebElement username = Driver.findElement(By.id("user_name"));
        WebElement password = Driver.findElement(By.id("username_password"));

        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        Driver.findElement(By.id("bigbutton")).click();

        String Homepagetext=Driver.findElement(By.id("tab0")).getText();
        Assert.assertEquals(Homepagetext, "SUITECRM DASHBOARD");



    }

    @AfterClass

    public void teardown() {
        Driver.quit();
    }


}
