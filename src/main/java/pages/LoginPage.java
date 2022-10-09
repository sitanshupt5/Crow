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

public class LoginPage extends BaseUtils {
    WebDriverWait webDriverWait;
    Logger log = LogManager.getLogger(LandingPage.class);

    @FindBy(xpath = "//input[@placeholder='E-mail address']")
    WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    WebElement loginButton;

    @FindBy(xpath = "//p[text()= \"Invalid login\"]")
    WebElement loginErrorMessage;


    public WebElement getLoginErrorMessage() {
        return loginErrorMessage;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void loadLoginPage() throws InterruptedException {
        Thread.sleep(3000);
        webDriverWait.until(ExpectedConditions.visibilityOf(username));
        webDriverWait.until(ExpectedConditions.visibilityOf(password));
        webDriverWait.until(ExpectedConditions.visibilityOf(loginButton));

    }

    public HomePage login(String uname, String pass){
        webDriverWait.until(ExpectedConditions.visibilityOf(username)).sendKeys(uname);
        webDriverWait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
        webDriverWait.until(ExpectedConditions.visibilityOf(loginButton)).click();
        return new HomePage(driver);
    }
}
