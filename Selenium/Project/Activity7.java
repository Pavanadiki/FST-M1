package CRMActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {


    WebDriver Driver;
    WebElement ele;

    @BeforeClass

    public void setup() {
//        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", "C:/Users/003H4Y744/IdeaProjects/geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        Driver = new FirefoxDriver();
        Driver.get("http://alchemy.hguy.co/crm");

    }

    @Test

    public void Login() throws InterruptedException {

        WebElement username = Driver.findElement(By.id("user_name"));
        WebElement password = Driver.findElement(By.id("username_password"));

        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        Driver.findElement(By.id("bigbutton")).click();
        Actions action = new Actions(Driver);
        WebElement Sales = Driver.findElement(By.id("grouptab_0"));
        action.moveToElement(Sales).perform();
        Driver.findElement(By.id("moduleTab_9_Leads")).click();

        Thread.sleep(3000);
        WebElement additionalDetails = Driver.findElement(By.xpath("(//span[@class='suitepicon suitepicon-action-info'])[1]"));
        additionalDetails.click();
        Thread.sleep(3000);
        WebElement phnNumber = Driver.findElement(By.xpath(" //span[@class='phone']"));
        System.out.println("PhoneNumber "+phnNumber.getText() );
    }

    @AfterClass


    public void teardown() {
        Driver.quit();
    }

}
