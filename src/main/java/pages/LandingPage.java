package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.BaseUtils;

import java.time.Duration;

public class LandingPage extends BaseUtils {
    WebDriverWait webDriverWait;
    Logger log = LogManager.getLogger(LandingPage.class);

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement loginLink;

    @FindBy(xpath = "//a[normalize-space()='Sign Up']")
    WebElement signUpLink;

    @FindBy(xpath = "//a[normalize-space()='Pricing']")
    WebElement pricingLink;

    @FindBy(xpath = "//a[normalize-space()='Features']")
    WebElement featuresLink;

    @FindBy(xpath = "//a[normalize-space()='Customers']")
    WebElement customersLink;

    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void loadLandingPage(){
        webDriverWait.until(ExpectedConditions.visibilityOf(loginLink));

    }

    public LoginPage openLoginPage(){
        webDriverWait.until(ExpectedConditions.visibilityOf(loginLink)).click();
        log.info("Login Page has been Opened");
        return new LoginPage(driver);
    }
}
