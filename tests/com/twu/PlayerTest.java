package com.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
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
        player = new Player(board, "X");
    }

    @Test
    public void shouldReturnXWhenPlayerMarkerIsX(){
        assertThat(player.getPlayerMarker(), is("X"));
    }

    @Test
    public void shouldSetBoardPieceWhenPlayerTakesTurn(){
        player.takeTurn(1);
        verify(board).setPiece(1,player);
    }

}
