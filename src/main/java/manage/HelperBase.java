package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
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

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void  openTabAnsSwitch(){
        ((JavascriptExecutor)wd).executeScript("window.open()");
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window((tabs.get(1)));
        wd.navigate().to("https://www.google.com/");

    }
     public void attachfile(By locator, File file){
        wd.findElement(locator).sendKeys(file.getAbsolutePath());

     }
    public void  waitForElementAndClick(By locator, int time){
        new WebDriverWait(wd, time).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
