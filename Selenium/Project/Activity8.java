package CRMActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Activity8 {


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
        WebElement Accounts = Driver.findElement(By.id("moduleTab_9_Accounts"));
        action.moveToElement(Accounts).click().perform();
        Thread.sleep(5000);


        Driver.findElement(By.xpath("(//h2[@class='module-title-text'])[1]")).getText();
        for(int i=3;i<=13;i=i+2){
            WebElement rowdata = Driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]"));
            System.out.println(rowdata.getText());
        }

    }

    @AfterClass

    public void teardown() {
        Driver.quit();
    }


}
