package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ContactsPage;
import pages.CreateContactsPage;
import pages.HomePage;
import pages.LoginPage;
import testbase.BaseUtils;

import java.time.Duration;

public class Steps extends BaseUtils{

    public LoginPage loginPage;
    public HomePage homePage;
    public ContactsPage contactsPage;
    public CreateContactsPage createContact;
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
    public void user_should_be_navigated_to_login_page() throws InterruptedException {
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
        homePage =loginPage.login(username,password);
        log.info("Login initiated");
    }

    @When("User clicks on the add contact button from the left nav")
    public void user_clicks_on_the_add_contact_button_from_the_left_nav() {
        createContact = homePage.addNewContact();
    }

    @Then("User is navigated to the create contact page")
    public void user_is_navigated_to_the_create_contact_page() throws InterruptedException {

    }

    @When("User click on save button")
    public void user_click_on_save_button() {
        createContact.saveContact();
    }

    @When("User adds firstName {string}, middleName {string}, lastName {string}, emailType {string}, emailId {string}, category {string}, status {string}, social_handle_type {string}, social_handle_id {string}, timezone {string}, street {string}, city {string}, province {string}, postal_code {string}, address_country {string}, phone_type {string}, number {string}, phone_country {string}, birth_day {string}, birth_month {string}, birth_year {string}, callblock {string}, textblock {string}, emailblock {string}, company {string}, tagName {string}, supervisor {string}, assistant {string}, referrer {string}")
    public void user_adds_contact_details(String firstName, String middleName, String lastName, String emailType, String emailId, String category, String status, String social_handle_type, String social_handle_id, String timezone, String street, String city, String province, String postal_code, String address_country, String phone_type, String number, String phone_country, String birth_day, String birth_month, String birth_year, String callblock, String textblock, String emailblock, String company, String tagName, String supervisor, String assistant, String referrer) {
        createContact.addContactName(firstName, middleName, lastName);
        createContact.addEmail(emailType, emailId);
        createContact.addSocialMediaHandle(social_handle_type, social_handle_id);
        createContact.setAddressDetails(street, city, province, postal_code, address_country);
        createContact.setContactDetails(phone_type,number, phone_country);
        createContact.setCategories(category);
        createContact.setStatus(status);
        createContact.setBirthDate(birth_day, birth_month, birth_year);
        createContact.setTimeZone(timezone);
        createContact.setPreferences(callblock, textblock, emailblock);
    }

    @When("User opens the contacts page")
    public void user_opens_the_contacts_page() throws InterruptedException {
        contactsPage = homePage.openContactsPage();
        Thread.sleep(2000);
    }

    @When("User clicks on the create button on contacts page")
    public void user_clicks_on_the_create_button() {
        createContact = contactsPage.createContact();
    }

}
