package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        System.setProperty("webdriver.chromedriver", "C:/Users/julia/Documents/QA/QA_Automation/QA/QA32_Trello/chromedriver.exe");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/");
    }

    @AfterMethod
    public void tearDown() {
        wd.close();
        wd.quit();
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }


    public void type(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
}

