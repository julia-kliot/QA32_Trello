package tests;

import model.Board;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {

    @Test
    public void boardCreation1() throws InterruptedException {

        Board board = Board.builder().title("testQA32").build();
        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().scrollDowmTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        int boardCountAfterCreation = app.getBoard().getBoardCount();

        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }

    @Test
    public void boardCreation2() throws InterruptedException {

        Board board = Board.builder().title("testQA32").build();

        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().scrollDowmTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());
    }

}
