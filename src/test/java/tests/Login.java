package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test
    public void loginSuccess() throws InterruptedException {
        //1.  click the  [href='/login']
        click(By.cssSelector("[href='/login']"));
        //2.  enter email #user
        type(By.cssSelector("#user"), "juliakliot.jk@gmail.com");
        //click the #login
        click(By.cssSelector("#login"));
        // enter pwd #password
        type(By.cssSelector("#password"), "misha240613");
        //click the #login-submit
        click(By.cssSelector("#login-submit"));
        Thread.sleep(5000);
        // [data-test-id='data-test-id']
        Assert.assertTrue(wd.findElements(By.cssSelector("[data-test-id='data-test-id']")).size()>0);




    }

}
