package stepDefinitions;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest extends BaseClass {

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Given("the user is on the TS homepage")
    public void openTSHomepage() {
        driver.get("https://www.training-support.net");
        Assertions.assertEquals("Training Support", driver.getTitle());
    }

    @When("the user clicks on the About Us link")
    public void clickAboutUsLink() {
        if (driver.findElement(By.id("about-link")).isEnabled()) {
            driver.findElement(By.id("about-link")).click();
        }
    }

    @Then("the user is redirected to the About page")
    public void verifyAboutPage(){
        Assertions.assertEquals("About Training Support", driver.getTitle());
       //Assert.assertEquals();
    }

    @And("close the browser")
    public void closeBrowser(){
        driver.quit();
    }
}
