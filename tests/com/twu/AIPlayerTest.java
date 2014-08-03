package com.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AIPlayerTest {

    private PrintStream out;
    private Board board;
    private AIPlayer aiPlayer1;
    private AIPlayer aiPlayer2;
    private Decider decider;

    @Before
    public void setUp(){
        out = mock(PrintStream.class);
        board = new Board(out);
        decider = mock(Decider.class);
        aiPlayer1 = new AIPlayer(board,"X",decider);
        aiPlayer2 = new AIPlayer(board,"O",decider);
    }

    @Test
    public void shouldGoForWinFirst(){
        board.gameBoard.add(1,aiPlayer1);
        board.gameBoard.add(5,aiPlayer1);

        aiPlayer1.takeTurn();

        verify(decider).goForWin(aiPlayer1);
    }

    @Test
    public void shouldBlockOpponent(){
        board.gameBoard.add(3,aiPlayer2);
        board.gameBoard.add(5,aiPlayer2);

        aiPlayer1.takeTurn();

        verify(decider).blockOpponent(aiPlayer1);
    }

}