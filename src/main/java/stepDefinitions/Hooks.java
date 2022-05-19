package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LandingPage;
import pages.LoginPage;
import testbase.BaseUtils;

import java.io.IOException;

public class Hooks extends BaseUtils {

    LandingPage landingPage;
    LoginPage loginPage;
    Logger log = LogManager.getLogger(Hooks.class);



    @Before
    public void setup(Scenario scenario) throws IOException, ClassNotFoundException {
        initializeDriver();
        openWebsite();

    }



    @AfterStep
    public void stepTearDown(Scenario scenario) throws IOException {
        final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
    }





    @After
    public void tearDown(Scenario scenario) throws IOException {

        closeBrowser();
    }
}
