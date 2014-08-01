package com.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by hanlei on 7/31/14.
 */
public class PlayerTest {

    private Player player;
    private Board board;
    private PrintStream out;

    @Before
    public void setUp(){
        out = mock(PrintStream.class);
        board = mock(Board.class);
        player = new Player(board, "1");
    }

    @Test
    public void shouldSetBoardPieceWhenPlayerTakesTurn(){
        player.takeTurn(1);
        verify(board).setPiece(anyInt(),anyInt());
    }

}
