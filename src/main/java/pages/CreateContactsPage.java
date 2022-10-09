package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.BaseUtils;

import java.time.Duration;

public class CreateContactsPage extends BaseUtils {
    WebDriverWait webDriverWait;
    Logger log = LogManager.getLogger(CreateContactsPage.class);

    @FindBy(xpath = "//div[text()= 'ui header item mb5 light-black']")
    private WebElement pageHeader;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='middle_name']")
    WebElement middleName;

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Email address']")
    WebElement email;

    @FindBy(xpath = "//input[@placeholder='Personal email, Business, Alt...']")
    WebElement emailType;

    @FindBy(xpath = "//div[@name='company']//input[@type='text']")
    WebElement companyName;

    @FindBy(xpath = "//label[text() = 'Tags']/following-sibling::label/div/input")
    WebElement tags;

    @FindBy(xpath = "//div[@name='category']//i[@class='dropdown icon']")
    WebElement categoryDropdownButton;

    @FindBy(xpath = "//div[@name='category']/div[@class='visible menu transition']")
    WebElement categories;

    @FindBy(xpath = "//div[@name='status']//i[@class='dropdown icon']")
    WebElement statusDropDownButton;

    @FindBy(xpath = "//div[@name='status']/div[@class='visible menu transition']/child::div")
    WebElement statuses;

    @FindBy(xpath = "//textarea[@name='description']")
    WebElement description;

    @FindBy(xpath = "//div[@name='channel_type']//i[@class='dropdown icon']")
    WebElement channelTypeDropDownButton;

    @FindBy(xpath = "//div[@name='channel_type']/div[@class='visible menu transition']/child::div")
    WebElement channelTypes;

    @FindBy(xpath = "//label[text()='Social Channels']/following-sibling::div/descendant::input")
    WebElement channelHandle;

    @FindBy(xpath = "//div[@name='timezone']//i[@class='dropdown icon']")
    WebElement timezoneDropDown;

    @FindBy(xpath = "//div[@name='timezone']/div[@class='visible menu transition']/child::div")
    WebElement timezones;

    @FindBy(xpath = "//input[@placeholder='Street Address']")
    WebElement streetAddress;

    @FindBy(xpath = "//input[@placeholder='City']")
    WebElement city;

    @FindBy(xpath = "//input[@placeholder='State / County']")
    WebElement province;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postalCode;

    @FindBy(xpath = "//div[@name='country']//i[@class='dropdown icon']")
    WebElement addressCountryDropDownButton;

    @FindBy(xpath = "//div[@name='country']/div[@class='visible menu transition']/child::div")
    WebElement addressCountries;

    @FindBy(xpath = "//div[@name='hint']//div[@role='alert'][normalize-space()='United States']")
    WebElement phoneCountryDropDownButton;

    @FindBy(xpath = "//div[@name='hint']/div[@class='visible menu transition']/child::div")
    WebElement phoneCountries;

    @FindBy(xpath = "//input[@placeholder='Number']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@placeholder='Home, Work, Mobile...']")
    WebElement phoneType;

    @FindBy(xpath = "//label[text()='Address']/following-sibling::div/descendant::button")
    WebElement addAddressButton;

    @FindBy(xpath = "//label[text()='Phone']/following-sibling::div/descendant::button")
    WebElement addPhoneButton;

    @FindBy(xpath = "//input[@name='position']")
    WebElement position;

    @FindBy(xpath = "//input[@name='department']")
    WebElement department;

    @FindBy(xpath = "//div[@name='supervisor']//input[@type='text']")
    WebElement supervisorName;

    @FindBy(xpath = "//div[@name='assistant']//input[@type='text']")
    WebElement assistantName;

    @FindBy(xpath = "//div[@name='referred_by']//input[@type='text']")
    WebElement referredBy;

    @FindBy(xpath = "//div[@name='source']//i[@class='dropdown icon']")
    WebElement sourceDropDownButton;

    @FindBy(xpath = "//div[@name='source']/div[@class='visible menu transition']/child::div")
    WebElement sources;

    @FindBy(xpath = "//div[@class='ui toggle checkbox']//label[contains(text(),'Do not Call')]")
    WebElement doNotCallButton;

    @FindBy(xpath = "//div[@class='ui toggle checkbox']//label[contains(text(),'Do not Text')]")
    WebElement doNotTextButton;

    @FindBy(xpath = "//div[@class='ui toggle checkbox']//label[contains(text(),'Do not Email')]")
    WebElement doNotEmailButton;

    @FindBy(xpath = "//input[@placeholder='Day']")
    WebElement day;

    @FindBy(xpath = "//div[@name='month']//i[@class='dropdown icon']")
    WebElement monthDropDownButton;

    @FindBy(xpath = "//div[@name='month']/div[@class='visible menu transition']/child::div")
    WebElement months;

    @FindBy(xpath = "//input[@placeholder='Year']")
    WebElement year;

    @FindBy(xpath = "//input[@name='identifier']")
    WebElement identifier;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement saveButton;

    @FindBy(xpath = "//button[@class='ui button']")
    WebElement cancelButton;

    public CreateContactsPage(WebDriver driver)
    {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void verifyCreateContactPageLoaded() throws InterruptedException {
        Thread.sleep(2000);
        webDriverWait.until(ExpectedConditions.visibilityOf(firstName));
    }

    public void addContactName(String first, String middle, String last)
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(first);
        webDriverWait.until(ExpectedConditions.visibilityOf(middleName)).sendKeys(middle);
        webDriverWait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(last);
    }

    public void addEmail(String type, String id)
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(email)).sendKeys(id);
        webDriverWait.until(ExpectedConditions.visibilityOf(emailType)).sendKeys(type);
    }

    public void addOtherDetails(String company, String tagName, String supervisor, String assistant, String referrer)
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(companyName)).sendKeys(company+ Keys.ENTER);
        webDriverWait.until(ExpectedConditions.visibilityOf(tags)).sendKeys(tagName+Keys.ENTER);
        supervisorName.sendKeys(supervisor+Keys.ENTER);
        assistantName.sendKeys(assistant+Keys.ENTER);
        referredBy.sendKeys(referrer+Keys.ENTER);
    }

    public void setCategories(String category)
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(categoryDropdownButton)).click();
        for(WebElement element:categories.findElements(By.xpath("/child::div")))
        {
            if(element.findElement(By.xpath("/span")).getText().equals(category))
                element.click();
        }
    }

    public void setStatus(String status)
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(statusDropDownButton)).click();
        for(WebElement element:statuses.findElements(By.xpath("/child::div")))
        {
            if(element.findElement(By.xpath("/span")).getText().equals(status))
                element.click();
        }
    }

    public void addSocialMediaHandle(String channel, String id)
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(channelTypeDropDownButton)).click();
        for(WebElement element:channelTypes.findElements(By.xpath("/child::div")))
        {
            if(element.findElement(By.xpath("/span")).getText().equals(channel))
                element.click();
        }
        channelHandle.sendKeys(id);
    }

    public void setTimeZone(String timeZoneId)
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(timezoneDropDown)).click();
        for(WebElement element:timezones.findElements(By.xpath("/child::div")))
        {
            if(element.findElement(By.xpath("/span")).getText().equals(timeZoneId))
                element.click();
        }
    }

    public void setAddressDetails(String street, String town, String state, String zip, String country)
    {
        streetAddress.sendKeys(street);
        city.sendKeys(town);
        province.sendKeys(state);
        postalCode.sendKeys(zip);
        webDriverWait.until(ExpectedConditions.visibilityOf(addressCountryDropDownButton)).click();
        for(WebElement element:addressCountries.findElements(By.xpath("/child::div")))
        {
            if(element.findElement(By.xpath("/span")).getText().equals(country))
                element.click();
        }
    }

    public void setContactDetails(String type, String number, String country){
        phoneType.sendKeys(type);
        phoneNumber.sendKeys(number);
        webDriverWait.until(ExpectedConditions.visibilityOf(phoneCountryDropDownButton)).click();
        for (WebElement element:phoneCountries.findElements(By.xpath("/child::div")))
        {
            if(element.findElement(By.xpath("/span")).getText().equals(country))
                element.click();
        }
    }

    public void setDesignation(String post, String deps){
        position.sendKeys(post);
        department.sendKeys(deps);
    }

    public void setPreferences(String call, String text, String email){
        if(Boolean.valueOf(call))
            doNotCallButton.click();
        if (Boolean.valueOf(text))
            doNotTextButton.click();
        if (Boolean.valueOf(email))
            doNotEmailButton.click();
    }

    public void addSource(String source)
    {
        sourceDropDownButton.click();
        for (WebElement element:sources.findElements(By.xpath("/child::div")))
        {
            if (element.findElement(By.xpath("/span")).getText().equals(source))
                element.click();
        }
    }

    public void setBirthDate(String dd, String mmm, String yyyy)
    {
        day.sendKeys(dd);
        monthDropDownButton.click();
        for (WebElement element:months.findElements(By.xpath("/child::div")))
        {
            if (element.findElement(By.xpath("/span")).getText().equals(mmm))
                element.click();
        }
        year.sendKeys(yyyy);
    }

    public void saveContact()
    {
        saveButton.click();
    }




}
