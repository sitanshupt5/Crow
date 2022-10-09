package testbase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

public class BaseUtils {

    public static WebDriver driver;
    public Properties properties;
    public static Actions actions;
    public static LandingPage landingPage;
    public static ExtentHtmlReporter report;
    public static ExtentReports extent;
    public static ExtentTest feat, test, node;
    public String report_directory;
    Logger logger = LogManager.getLogger(BaseUtils.class);

    public void initializeDriver() throws IOException {
        properties = new Properties();
        FileInputStream projectConfigFile= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\properties\\project_config.properties");
        properties.load(projectConfigFile);
        if(properties.getProperty("browser").equals("chrome"))
        {
            driver = WebDriverManager.chromedriver().create();
            driver.manage().window().maximize();
            actions = new Actions(driver);
        }
    }

    public void openWebsite() throws IOException {
        driver.get("https://freecrm.com/");
        landingPage = new LandingPage(driver);
        logger.info(driver.getCurrentUrl() +"site has been opened");
    }

    public void closeBrowser()
    {
        driver.close();
        driver.quit();
    }

    public static String generateTimeStamp(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
        return sdf.format(date);
    }


    public static String getBase64Screenshot() throws IOException {
        String base64StringofScreenshot = "";
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String sDate = generateTimeStamp();
        FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/test-output/screenshots/"+ "image_"+sDate+".png"));

        byte[] fileContent = FileUtils.readFileToByteArray(src);
        base64StringofScreenshot = "data:img/png;base64"+ Base64.getEncoder().encodeToString(fileContent);
        return base64StringofScreenshot;
    }

    public static File screenShot() throws IOException {
        TakesScreenshot shot  = (TakesScreenshot) driver;
        File imgFile = shot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./test-output/screenshots/img.png");
        FileUtils.copyFile(imgFile, destFile);
        return destFile;
    }

    public static void setReportConfig(){
        String reportPath = "./test-output/Reports/extentreports.html";
        report = new ExtentHtmlReporter(reportPath);
        report.config().setDocumentTitle("Automation Report");
        report.config().setReportName("Crow Report");
        report.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("Application", "FreeCRM");
        extent.setSystemInfo("Operating System",System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));

    }

    public static void testStepHandle(String testStatus, WebDriver driver, ExtentTest test)
    {
        switch (testStatus)
        {
            case "FAIL":
                test.fail(MarkupHelper.createLabel("Test case is Failed: ", ExtentColor.RED));
                if (driver!=null)
                    driver.quit();
                break;
            case "PASS":
                test.pass(MarkupHelper.createLabel("Test case is Passed: ", ExtentColor.GREEN));
                break;
            default:
                break;
        }
    }






}
