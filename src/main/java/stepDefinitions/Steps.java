package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import testbase.BaseUtils;

import java.time.Duration;

public class Steps extends BaseUtils{

    public LoginPage loginPage;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    Logger log = LogManager.getLogger(Steps.class);

    @Given("User is on Landing Page")
    public void user_is_on_landing_page() {
        landingPage.loadLandingPage();
        Assert.assertFalse("Landing Page is not loaded",driver.getTitle().isEmpty());
        log.info("Landing page has been loaded");

    }

    @When("User clicks on the Login link")
    public void user_clicks_on_the_login_link() {
        loginPage = landingPage.openLoginPage();
        log.info("Login link has been clicked");
    }
    @Then("User should be navigated to Login Page")
    public void user_should_be_navigated_to_login_page(){
        loginPage.loadLoginPage();
        Assert.assertTrue("Login Page is not loaded",loginPage.getUsername().isDisplayed());
        log.info("Login page has been loaded successfully");
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully(){
        Assert.assertTrue("Homepage is not loaded",driver.getTitle().equals("Cogmento CRM"));
        log.info("Login successfull");
    }

    @Then("User should not be logged in successfully")
    public void user_should_not_be_logged_in_successfully(){
        Assert.assertTrue("Login error message is displayed", wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginErrorMessage())).getText().equals("Invalid Login"));
        log.info("Login failed. Error message displayed: "+loginPage.getLoginErrorMessage().getText());
    }

    @When("User logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password){
        loginPage.login(username,password);
        log.info("Login initiated");
    }

}
