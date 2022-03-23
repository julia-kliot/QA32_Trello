package tests;

import model.Board;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {

    @Test
    public void boardCreation1() throws InterruptedException {
        Board board = new Board().withTitle("testQA32");

        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().scrollDowmTheForm();
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();
        app.getBoard().returnToHomePage();

    }
}
