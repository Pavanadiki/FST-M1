package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SimpleAlert {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");
        driver.findElement(By.id("firstName")).sendKeys("Anjali");
        driver.findElement(By.id("lastName")).sendKeys("Lathiya");
        driver.findElement(By.id("email")).sendKeys("a@a.com");
        driver.findElement(By.id("number")).sendKeys("9999900000");
       // driver.findElement(By.id("simpleForm")).submit();
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Switch focus to the alert and print it
        Alert message = driver.switchTo().alert();
        System.out.println(message.getText());
        message.accept();

        driver.quit();
    }
}
