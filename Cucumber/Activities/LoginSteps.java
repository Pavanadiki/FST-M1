package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginSteps extends BaseClass {

    @Given("user is on Login page")
    public void openLoginPage() {
        driver.get("https://www.training-support.net/selenium/login-form");
        Assertions.assertEquals("Login Form", driver.getTitle());
    }



    @When("Verify the confirmation message")
    public void confMsg() {
    String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
    Assertions.assertEquals("Welcome Back, admin", loginMessage);
    }
}
