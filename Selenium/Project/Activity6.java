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

public class Activity6 {


    WebDriver Driver;

    @BeforeClass

    public void setup() {
       // WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", "C:/Users/003H4Y744/IdeaProjects/geckodriver.exe");

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

        String Activities = Driver.findElement(By.id("grouptab_3")).getText();
        Assert.assertEquals(Activities, "ACTIVITIES");
        Driver.findElement(By.id("grouptab_3")).click();

        String Notestext = Driver.findElement(By.id("moduleTab_9_Notes")).getText();
        Assert.assertEquals(Notestext, "Notes");
        System.out.println("This Activities tab is clickable");

    }

    @AfterClass

    public void teardown() {
        Driver.quit();
    }

}
