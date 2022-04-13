package manage;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class MyListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    public MyListener() {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("The element with locator-----" + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("The element with locator---" + by + "---was found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("We have a 'throwable'-----" + throwable.getMessage());
        logger.info(throwable.fillInStackTrace().toString());

        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        String link = "C:/Users/julia/Documents/QA/QA_Automation/QA/QA32_Trello/src/test/resources/screenshots/screen" + index + ".png";

        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screen = new File(link);

        try{
            Files.copy(tmp,screen);
        }
        catch (IOException exc){
            exc.printStackTrace();
        }
    }
}
