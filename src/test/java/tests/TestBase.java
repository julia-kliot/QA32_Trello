package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import manage.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setApp() throws InterruptedException {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
       app.stop();
    }

    @BeforeMethod
    public void startLogger(Method method){
        logger.info("Start test----"+method.getName());
    }
     @AfterMethod
    public void finishLog(){
        logger.info("********************************************************************************************************************************");
     }


}

