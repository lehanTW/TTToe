package com.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class DeciderTest {

    private AIPlayer aiPlayer;
    private Board board;
    private PrintStream out;
    private Decider decider;

    @Before
    public void setUp(){
        aiPlayer = mock(AIPlayer.class);
        out = mock(PrintStream.class);
        board = new Board(out);
        decider = new Decider(board);
    }


    @Test
    public void shouldGoAtPosition1WhenBoardIsEmpty(){
        assertThat(decider.goForNextEmpty(), is(1));
    }

    @Test
    public void shouldGoAtPosition5WhenPositions1Through4AreTaken(){
        board.gameBoard.add(1,aiPlayer);
        board.gameBoard.add(2,aiPlayer);
        board.gameBoard.add(3,aiPlayer);
        board.gameBoard.add(4,aiPlayer);

        assertThat(decider.goForNextEmpty(), is(5));
    }

    @Test
    public void shouldPlayWinningMoveAtPosition6(){
        board.gameBoard.add(4,aiPlayer);
        board.gameBoard.add(5,aiPlayer);

        assertThat(decider.goForWin(aiPlayer), is(6));
    }

    @Test
    public void shouldPlayWinningMoveAtPosition5(){
        board.gameBoard.add(3,aiPlayer);
        board.gameBoard.add(7,aiPlayer);

        assertThat(decider.goForWin(aiPlayer),is(5));
    }

/*
    @Test
    public void shouldMakeWinningPlayAtPosition3(){
        Board localBoard = new Board(out);
        AIPlayer localPlayer = new AIPlayer(localBoard, "X");


    }
*/


}