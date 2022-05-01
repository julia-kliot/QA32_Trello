package tests;

import manage.MyDataProvider;
import model.Board;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BoardCreation extends TestBase {


        @Test (dataProvider = "boardDataModel", dataProviderClass = MyDataProvider.class)
        public void boardCreation1 (Board board)  {

            //Board board = Board.builder().title("testQA32").build();
            int boardCountBeforeCreation = app.getBoard().getBoardCount();
            logger.info("Test boardcreation 1" + board.getTitle());
            app.getBoard().initBoardCreationFromHeader();
            app.getBoard().fillBoardCreationForm(board);
            app.getBoard().scrollDowmTheForm();
            app.getBoard().pause(2000);
            app.getBoard().submitBoardCreation();
            app.getBoard().pause(2000);
            app.getBoard().returnToHomePage();
            int boardCountAfterCreation = app.getBoard().getBoardCount();
            logger.info("Board is created");

            Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
        }
    @Test (groups = {"logs"},invocationCount = 1)
    public void boardCreation4 ()  {

        Board board = Board.builder().title("testQA32").build();
        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        logger.info("Test boardcreation 1" + board.getTitle());
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().scrollDowmTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        int boardCountAfterCreation = app.getBoard().getBoardCount();
        logger.info("Board is created");

        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }

    @Test (groups = {"board"},invocationCount = 1)
    public void boardCreation5 ()  {

        Board board = Board.builder().title("testQA32").build();
        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        logger.info("Test boardcreation 1" + board.getTitle());
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().scrollDowmTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        int boardCountAfterCreation = app.getBoard().getBoardCount();
        logger.info("Board is created");

        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }

        @Test
        public void boardCreation2 ()  {

            Board board = Board.builder().title("testQA32").build();

            app.getBoard().initBoardCreationFromHeader();
            app.getBoard().fillBoardCreationForm(board);
            app.getBoard().scrollDowmTheForm();
            app.getBoard().pause(2000);
            app.getBoard().submitBoardCreation();
            app.getBoard().isCreated();

            Assert.assertTrue(app.getBoard().isCreated());
        }
        @Test(dataProvider = "boardData", dataProviderClass = MyDataProvider.class)
        public void boardCreation3 (String boardName)  {

            // Board board = Board.builder().title("testQA32").build();
            int boardCountBeforeCreation = app.getBoard().getBoardCount();
            logger.info("Test boardcreation 1" + boardName);
            app.getBoard().initBoardCreationFromHeader();
            app.getBoard().fillBoardCreationForm(boardName);
            app.getBoard().scrollDowmTheForm();
            app.getBoard().pause(2000);
            app.getBoard().submitBoardCreation();
            app.getBoard().pause(2000);
            app.getBoard().returnToHomePage();
            int boardCountAfterCreation = app.getBoard().getBoardCount();
            logger.info("Board is created");

            Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
        }


    }
