package com.twu;

import com.twu.GameDriver;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BoardDriverTest {

    private GameDriver driver;
    private PrintStream out;
    private InputStream in;
    private Player player1;
    private Player player2;
    private Board board;

    @Before
    public void setUp(){
        out = mock(PrintStream.class);
        in = mock(InputStream.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        board = mock(Board.class);
        driver = new GameDriver(out, new BufferedReader(new InputStreamReader(in)),board,player1,player2);
    }

    @Test
    public void shouldReturn5WhenUserInputs5() throws IOException {
        BufferedReader fakeReader = mock(BufferedReader.class);
        when(fakeReader.readLine()).thenReturn("5");

        driver = new GameDriver(out, fakeReader,board,player1,player2);

        assertThat(driver.getUserInput(), is("5"));
    }

    @Test
    public void shouldSetPieceAtPosition1WhenPlayer1Plays1() throws IOException {
        BufferedReader fakeReader = mock(BufferedReader.class);
        when(fakeReader.readLine()).thenReturn("1");

        driver = new GameDriver(out, fakeReader,board,player1,player2);
        driver.play();

        verify(board).setPiece(1, player1);
    }

    @Test
    public void shouldPrintGameDrawMessageWhenBoardIsFull(){
        driver = new GameDriver(out, new BufferedReader(new InputStreamReader(in)),new Board(out),player1,player2);

        for(int i=0; i<=9; i++){
            driver.board.gameBoard.set(i,player1);
        }

        driver.play();
        verify(out).println("Game is a draw!");
    }

}