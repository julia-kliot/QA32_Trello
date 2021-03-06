package tests;

import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }

    }

    @Test
    public void loginSuccess() throws InterruptedException {

        app.getUser().initLogin();
        app.getUser().fillLoginForm("juliakliot.jk@gmail.com", "misha240613");
        app.getUser().submitLogin();
        //Thread.sleep(5000);
        app.getUser().isLoggedSuccess();

        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }

    @Test
    public void loginSuccessmodel() throws InterruptedException {

        User user = User.builder().email("juliakliot.jk@gmail.com").password("misha240613").build();
        logger.info("Test Login Positive 1"+ user.getEmail()+ " " +user. getPassword());
        app.getUser().initLogin();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        //Thread.sleep(5000);
        app.getUser().isLoggedSuccess();
        logger.info("Logged---");

        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }

    @Test
    public void loginWithEmptyPassword() throws InterruptedException {
        app.getUser().initLogin();
        app.getUser().fillLoginForm("juliakliot.jk@gmail.com", "misha");
        app.getUser().submitLogin();


    }

    @Test
    public void loginWithNegPassword() throws InterruptedException {
        app.getUser().initLogin();
        app.getUser().fillLoginForm("juliakliot.jk@gmail.com", "");
        app.getUser().submitLogin();


    }


}


