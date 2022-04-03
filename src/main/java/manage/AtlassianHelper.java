package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class AtlassianHelper extends HelperBase{
    public AtlassianHelper(WebDriver wd) {
        super(wd);
    }
    public void  initChangeAvatar(){
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-hover-info']")))
                .pause(3).click(wd.findElement(By.cssSelector(".css-1ujqpe8"))).perform();
        click(By.xpath("//*[@role='menuitem'] [1]"));
    }

    public void uploadPhoto(){
        attachfile(By.cssSelector("#image-input"),new File("C:/Users/julia/Documents/QA/QA_Automation/QA/QA32_Trello/src/test/resources/Dogs_Shih_Tzu_466102.jpg"));
        waitForElementAndClick(By.cssSelector(".css-19r5em7"), 10);
    }
}
