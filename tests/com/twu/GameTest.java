package com.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class GameTest {

    private Game game;
    private PrintStream out;
    private InputStream in;
    private Player player1;
    private Player player2;
    private Board board;
    private BufferedReader reader;

    @Before
    public void setUp(){
        out = mock(PrintStream.class);
        in = mock(InputStream.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        board = mock(Board.class);
        reader = mock(BufferedReader.class);
        game = new Game(out,reader,board,player1,player2);
    }

    @Test
    public void shouldReturn5WhenUserInputs5() throws IOException {
        when(reader.readLine()).thenReturn("5");

        assertThat(game.getUserInput(), is("5"));
    }

    @Test
    public void shouldPlayAtPosition1WhenPlayer1Plays1() throws IOException {

        when(reader.readLine()).thenReturn("1");
        when(board.boardIsFull()).thenReturn(false, true);

        game.play();

        verify(player1).takeTurn(1);

    }

    @Test
    public void shouldPrintGameDrawMessageWhenBoardIsFull(){
        game = new Game(out, new BufferedReader(new InputStreamReader(in)),new Board(out),player1,player2);

        for(int i=0; i<=9; i++){
            game.board.gameBoard.set(i,player1);
        }

        game.play();
        verify(out).println("Game is a draw!");
    }

}