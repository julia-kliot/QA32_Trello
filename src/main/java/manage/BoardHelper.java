package manage;

import model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase {
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void initBoardCreationFromHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
        click(By.cssSelector("[aria-label='BoardIcon']"));
    }

    public void fillBoardCreationForm(Board board) {
        type(By.cssSelector("[data-test-id = 'create-board-title-input']"), board.getTitle());
    }
     public  void scrollDowmTheForm(){
         Actions action = new Actions(wd);
         WebElement container = wd.findElement(By.cssSelector("[data-test-id='header-create-menu-popover']"));
         Rectangle rect = container.getRect();
         int x= rect.getX()+10;
         int y= rect.getY()+ rect.getHeight()/2;
         action.moveByOffset(x,y).click().perform();

     }

     public void  submitBoardCreation() throws InterruptedException {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        Thread.sleep(5000);
     }

     public boolean isCreated(){
             WebDriverWait wait= new WebDriverWait(wd,20);
             wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".list-name-input"))));
             return wd.findElement(By.cssSelector(".list-name-input")).isDisplayed();

     }
    public void returnToHomePage(){
        click(By.cssSelector("._2ft40Nx3NZII2i"));
    }




}
