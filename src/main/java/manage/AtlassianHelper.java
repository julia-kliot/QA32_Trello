package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class AtlassianHelper extends HelperBase{
    public AtlassianHelper(WebDriver wd) {
        super(wd);
    }
   // public void  initChangeAvatar(){
       // new Actions(wd).moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']")))
              //  .pause(3).click(wd.findElement(By.cssSelector(".css-1ujqpe8"))).perform();
       // click(By.xpath("//*[@role='menuitem'] [1]"));
  //  }

    public void uploadPhoto(){
        attachfile(By.cssSelector("#image-input"),new File("C:/Users/julia/Documents/QA/QA_Automation/QA/QA32_Trello/src/test/resources/download_dog.jpg"));
        waitForElementAndClick(By.cssSelector(".css-12eh8h8"), 10);
    }
    public void initChangePhoto() {
        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']")))
                .click().perform();
        pause(3000);
        click(By.xpath("//*[@role='menuitem'][1]"));
    }
    public void uploadPhoto2(String url) {
        wd.findElement(By.cssSelector("#image-input")).sendKeys(url);
        click(By.cssSelector(".css-12eh8h8"));
    }
    public boolean isAvatarChanged() {
        pause(2000);
        //css-ygd4ga
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".css-ygd4ga"))));
        return wd.findElement(By.cssSelector(".css-ygd4ga")).isDisplayed();
    }
}
