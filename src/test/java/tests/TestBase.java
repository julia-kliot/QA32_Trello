package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import manage.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();


    @BeforeSuite
    public void setApp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
       app.stop();
    }


}

