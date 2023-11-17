package CRMActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {

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
        //  action.moveToElement(leads).click().perform();
        Thread.sleep(3000);
        for(int i=1;i<=10;i++) {
            WebElement leadDetails = Driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]/b"));
            String leadName = leadDetails.getText();
            System.out.print(leadName);

            WebElement leadDetails2 = Driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]"));
            String leadUserName = leadDetails2.getText();
            System.out.println(" --> "+leadUserName);


        }

    }

        @AfterClass


        public void teardown() {
        Driver.quit();
    }

}
