package manage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    UserHelper user;
    BoardHelper board;

    public void init() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        System.setProperty("webdriver.chromedriver", "C:/Users/julia/Documents/QA/QA_Automation/QA/QA32_Trello/chromedriver.exe");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/");

        user= new UserHelper(wd);
        board = new BoardHelper(wd);
        user.login("juliakliot.jk@gmail.com","misha240613");
    }

    public BoardHelper getBoard() {
        return board;
    }

    public void stop(){
        //wd.close();
       // wd.quit();
    }

    public UserHelper getUser() {
        return user;
    }
}