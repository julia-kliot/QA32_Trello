package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserModification extends TestBase {


    @Test
    public void testNewTab() {
        app.getUser().openTabAnsSwitch();
        app.getUser().pause(1000);

    }

    @Test
    public void testChangeAvatar(){

        app.getUser().clickOnAvatar();
        app.getUser().openUserProfile();
        app.getUser().goToTheAtlassianAccount();
        app.getUser().pause(2000);

        String url = app.getUrl();
       Assert.assertEquals(url,"https://id.atlassian.com/manage-profile/profile-and-visibility");

       app.getAtlassian().initChangePhoto();
       app.getAtlassian().uploadPhoto();
       app.getAtlassian().pause(10000);
       app.getUser().returnToTrello();
       app.getUser().pause(2000);

        String curUrl = app.getUrl();
       // Assert.assertEquals(curUrl,"https://trello.com/juliakliotjk/boards");

    }

    @Test
    public void changeAvatarTest(){
        app.getUser().clickOnAvatar();
        app.getUser().openUserProfile();
        app.getUser().goToTheAtlassianAccount();
        app.getUser().pause(3000);

        Assert.assertTrue(app.getUrl().contains("https://id.atlassian.com/manage-profile"));

        app.getAtlassian().initChangePhoto();
        app.getAtlassian().uploadPhoto2("C:/Users/julia/Documents/QA/QA_Automation/QA/QA32_Trello/src/test/resources/download_dog.jpg");
      //  Assert.assertTrue(app.getAtlassian().isAvatarChanged());
        app.getUser().returnToTrello();

        Assert.assertTrue(app.getUrl().contains("https://trello.com"));



}
}


