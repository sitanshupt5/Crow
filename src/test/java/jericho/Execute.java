package jericho;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class Execute {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//java//resources//chromedriver.exe");
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/popup.php");
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator it = windows.iterator();
        String currentWindow = (String) it.next();
        String newWindow = (String)it.next();
        driver.switchTo().window(newWindow);
        Thread.sleep(5000);
    }
}
