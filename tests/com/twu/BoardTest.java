package com.twu;

import com.twu.Board;
import com.twu.GameDriver;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private PrintStream out;
    private GameDriver driver;
    private Board board;

    @Before
    public void setUp(){
        out = mock(PrintStream.class);
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

        board.setPiece(5, 1);
        assertThat(board.gameBoard.get(5),is(1));
    }

    @Test
    public void shouldDrawAnXInTopRightWhenBoardPosition3IsSetTo1(){
        board.gameBoard.set(3, 1);
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
        board.gameBoard.set(1, 2);
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
        board.gameBoard.set(3,1);
        assertThat(board.setPiece(3,1),is(false));
    }

    @Test
    public void shouldReturnFalseIfBoardIsNotFullWhenCallingBoardIsFull(){
        assertThat(board.boardIsFull(), is(false));
    }

    @Test
    public void shouldReturnTrueIfBoardIsFullWhenCallingBoardIsFull(){
        for(int i=0; i<=9; i++){
            board.gameBoard.set(i,1);
        }

        assertThat(board.boardIsFull(),is(true));
    }

    @Test
    public void shouldReturnFalseWhenGameIsWonCalledAndGameIsNotWon(){
        assertThat(board.gameIsWon(), is(false));
    }

    @Test
    public void shouldReturnTrueWhenGameIsWonCalledAndPosition123IsSetTo1(){
        board.gameBoard.set(1,1);
        board.gameBoard.set(2,1);
        board.gameBoard.set(3,1);

        assertThat(board.gameIsWon(), is(true));
    }

    @Test
    public void shouldReturnTrueWhenGameIsWonCalledAndPosition519IsSetTo2(){
        board.gameBoard.set(5,2);
        board.gameBoard.set(1,2);
        board.gameBoard.set(9,2);

        assertThat(board.gameIsWon(), is(true));
    }

}