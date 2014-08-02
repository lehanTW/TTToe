package com.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BoardTest {

    private PrintStream out;
    private Game driver;
    private Board board;
    private Player player1;
    private Player player2;

    @Before
    public void setUp(){
        out = mock(PrintStream.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);

        when(player1.getPlayerMarker()).thenReturn("X");
        when(player2.getPlayerMarker()).thenReturn("O");

        board = new Board(out);
    }

    @Test
    public void shouldDrawEmptyBoardWhenNoPlaysMade(){

        board.printBoard();

        verify(out).print(
        "   |   |   \n" +
        "-----------\n" +
        "   |   |   \n" +
        "-----------\n" +
        "   |   |   \n"
        );
    }

    @Test
    public void shouldSetBoardPosition5To1IfSetPieceIsCalledWith5And1(){
        assertThat(board.setPiece(5, player1), is(true));
        assertThat(board.gameBoard.get(5),is(player1));
    }

    @Test
    public void shouldDrawAnXInTopRightWhenBoardPosition3IsSetTo1(){
        board.gameBoard.set(3, player1);
        board.printBoard();

        verify(out).print(
            "   |   | X \n" +
            "-----------\n" +
            "   |   |   \n" +
            "-----------\n" +
            "   |   |   \n"
        );
    }

    @Test
    public void shouldDrawAnOInTopLeftWhenBoardPosition1IsSetTo2(){
        board.gameBoard.set(1, player2);
        board.printBoard();

        verify(out).print(
            " O |   |   \n" +
            "-----------\n" +
            "   |   |   \n" +
            "-----------\n" +
            "   |   |   \n"
        );
    }

    @Test
    public void shouldGetFalseIfInputPositionAlreadyTaken(){
        board.gameBoard.set(3,player1);
        assertThat(board.setPiece(3,player1),is(false));
    }

    @Test
    public void shouldReturnFalseIfBoardIsNotFullWhenCallingBoardIsFull(){
        assertThat(board.boardIsFull(), is(false));
    }

    @Test
    public void shouldReturnTrueIfBoardIsFullWhenCallingBoardIsFull(){
        for(int i=0; i<=9; i++){
            board.gameBoard.set(i,player1);
        }

        assertThat(board.boardIsFull(),is(true));
    }

    @Test
    public void shouldReturnFalseWhenGameIsWonCalledAndGameIsNotWon(){
        assertThat(board.gameIsWon(), is(false));
    }

    @Test
    public void shouldReturnTrueWhenGameIsWonCalledAndPosition123IsSetTo1(){
        board.gameBoard.set(1,player1);
        board.gameBoard.set(2,player1);
        board.gameBoard.set(3,player1);

        assertThat(board.gameIsWon(), is(true));
    }

    @Test
    public void shouldReturnTrueWhenGameIsWonCalledAndPosition519IsSetTo2(){
        board.gameBoard.set(5,player2);
        board.gameBoard.set(1,player2);
        board.gameBoard.set(9,player2);

        assertThat(board.gameIsWon(), is(true));
    }

}