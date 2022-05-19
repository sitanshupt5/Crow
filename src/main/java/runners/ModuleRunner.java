package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.runner.RunWith;
import testbase.BaseUtils;

import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/java/features/Module1.feature"},
        glue = {"stepDefinitions"},
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//
)

public class ModuleRunner extends BaseUtils {

    @Before
    public void cleanFolders() throws IOException {
        if((new File(System.getProperty("user.dir")+"/test-output/")).exists())
        {
            FileUtils.cleanDirectory(new File(System.getProperty("user.dir")+"/test-output/screenshots/"));
        }
    }


}
