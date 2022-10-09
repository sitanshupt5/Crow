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

public class ContactsPage extends BaseUtils {

    WebDriverWait webDriverWait;
    Logger log = LogManager.getLogger(ContactsPage.class);

    @FindBy(xpath = "//button[normalize-space()='Create']")
    WebElement createContactButton;

    public ContactsPage(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public WebElement getCreateContactButton() {
        return createContactButton;
    }

    public CreateContactsPage createContact()
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(createContactButton)).click();
        return new CreateContactsPage(driver);
    }
}
