package com.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class DeciderTest {

    private AIPlayer aiPlayer1;
    private AIPlayer aiPlayer2;
    private Board board;
    private PrintStream out;
    private Decider decider;

    @Before
    public void setUp(){
        aiPlayer1 = mock(AIPlayer.class);
        aiPlayer2 = mock(AIPlayer.class);
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
        board.gameBoard.add(1, aiPlayer1);
        board.gameBoard.add(2, aiPlayer1);
        board.gameBoard.add(3, aiPlayer1);
        board.gameBoard.add(4, aiPlayer1);

        assertThat(decider.goForNextEmpty(), is(5));
    }

    @Test
    public void shouldPlayWinningMoveAtPosition6(){
        board.gameBoard.add(4, aiPlayer1);
        board.gameBoard.add(5, aiPlayer1);

        assertThat(decider.goForWin(aiPlayer1), is(6));
    }

    @Test
    public void shouldPlayWinningMoveAtPosition5(){
        board.gameBoard.add(3, aiPlayer1);
        board.gameBoard.add(7, aiPlayer1);

        assertThat(decider.goForWin(aiPlayer1),is(5));
    }

    @Test
    public void shouldBlockOpponentAtPosition9(){
        board.gameBoard.add(7,aiPlayer2);
        board.gameBoard.add(8,aiPlayer2);

        assertThat(decider.blockOpponent(aiPlayer1), is(9));
    }

    @Test
    public void shouldBlockOpponentAtPosition5(){
        board.gameBoard.add(3,aiPlayer2);
        board.gameBoard.add(7,aiPlayer2);

        assertThat(decider.blockOpponent(aiPlayer1), is(5));
    }

    @Test
    public void shouldForkAtPosition7(){
        board.gameBoard.add(1,aiPlayer1);
        board.gameBoard.add(3,aiPlayer1);

        assertThat(decider.fork(aiPlayer1), is(7));
    }

   @Test
    public void shouldForkAtPosition9(){
        board.gameBoard.add(3,aiPlayer1);
        board.gameBoard.add(7,aiPlayer1);

        board.gameBoard.add(2,aiPlayer2);
        board.gameBoard.add(5,aiPlayer2);

        assertThat(decider.fork(aiPlayer1), is(9));
    }


}