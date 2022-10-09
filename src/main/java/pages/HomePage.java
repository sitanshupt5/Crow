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

public class HomePage extends BaseUtils {
    WebDriverWait webDriverWait;
    Logger log = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//div[@id ='main-nav']")
    WebElement navigationBar;

    @FindBy(xpath = "//a[@href = '/home']")
    WebElement homeLink;

    @FindBy(xpath = "//a[@href = '/calendar']")
    WebElement calendarLink;

    @FindBy(xpath = "//a[@href = '/contacts']")
    WebElement contactsLink;

    @FindBy(xpath = "//a[@href = '/companies']")
    WebElement companiesLink;

    @FindBy(xpath = "//a[@href = '/deals']")
    WebElement dealsLink;

    @FindBy(xpath = "//a[@href = '/tasks']")
    WebElement tasksLink;

    @FindBy(xpath = "//a[@href = '/cases']")
    WebElement casesLink;

    @FindBy(xpath = "//a[@href = '/calls']")
    WebElement callsLink;

    @FindBy(xpath = "//a[@href = '/documents']")
    WebElement documentsLink;

    @FindBy(xpath = "//a[@href = '/email']")
    WebElement emailLink;

    @FindBy(xpath = "//a[@href = '/campaigns']")
    WebElement campaignsLink;

    @FindBy(xpath = "//a[@href = '/forms']")
    WebElement formsLink;

    @FindBy(xpath = "//a[@href = '/calendar']/following-sibling::button")
    WebElement addToCalendarButton;

    @FindBy(xpath = "//a[@href = '/contacts']/following-sibling::button")
    WebElement addToContactsButton;

    @FindBy(xpath = "//a[@href = '/companies']/following-sibling::button")
    WebElement addToCompaniesButton;

    @FindBy(xpath = "//a[@href = '/deals']/following-sibling::button")
    WebElement addToDealsButton;

    @FindBy(xpath = "//a[@href = '/tasks']/following-sibling::button")
    WebElement addToTasksButton;

    @FindBy(xpath = "//a[@href = '/cases']/following-sibling::button")
    WebElement addToCasesButton;

    @FindBy(xpath = "//a[@href = '/calls']/following-sibling::button")
    WebElement addToCallsButton;

    @FindBy(xpath = "//a[@href = '/documents']/following-sibling::button")
    WebElement addToDocumentsButton;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public ContactsPage openContactsPage(){
        webDriverWait.until(ExpectedConditions.visibilityOf(contactsLink)).click();
        return new ContactsPage(driver);
    }

    public CreateContactsPage addNewContact(){
        actions.moveToElement(navigationBar).moveToElement(addToContactsButton).click(addToContactsButton).build().perform();
        return new CreateContactsPage(driver);
    }

    public WebElement getNavigationBar() {
        return navigationBar;
    }

    public WebElement getHomeLink() {
        return homeLink;
    }

    public WebElement getCalendarLink() {
        return calendarLink;
    }

    public WebElement getContactsLink() {
        return contactsLink;
    }

    public WebElement getCompaniesLink() {
        return companiesLink;
    }

    public WebElement getDealsLink() {
        return dealsLink;
    }

    public WebElement getTasksLink() {
        return tasksLink;
    }

    public WebElement getCasesLink() {
        return casesLink;
    }

    public WebElement getCallsLink() {
        return callsLink;
    }

    public WebElement getDocumentsLink() {
        return documentsLink;
    }

    public WebElement getEmailLink() {
        return emailLink;
    }

    public WebElement getCampaignsLink() { return campaignsLink; }

    public WebElement getFormsLink() {
        return formsLink;
    }

    public WebElement getAddToCalendarButton() {
        return addToCalendarButton;
    }

    public WebElement getAddToContactsButton() {
        return addToContactsButton;
    }

    public WebElement getAddToCompaniesButton() {
        return addToCompaniesButton;
    }

    public WebElement getAddToDealsButton() {
        return addToDealsButton;
    }

    public WebElement getAddToTasksButton() {
        return addToTasksButton;
    }

    public WebElement getAddToCasesButton() {
        return addToCasesButton;
    }

    public WebElement getAddToCallsButton() {
        return addToCallsButton;
    }

    public WebElement getAddToDocumentsButton() {
        return addToDocumentsButton;
    }
}
