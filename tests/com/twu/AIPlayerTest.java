package com.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

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

}