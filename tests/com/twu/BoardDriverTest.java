package com.twu;

import com.twu.GameDriver;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardDriverTest {

    private GameDriver driver;
    private PrintStream out;
    private InputStream in;

    @Before
    public void setUp(){
        out = mock(PrintStream.class);
        in = mock(InputStream.class);
        driver = new GameDriver(out,in);
    }

    @Test
    public void shouldReturn5WhenUserInputs5(){
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
        assertThat(driver.getUserInput(in), is("5"));
    }

    @Test
    public void shouldPrintGameDrawMessageWhenBoardIsFull(){
        for(int i=0; i<=9; i++){
            driver.board.gameBoard.set(i,1);
        }
        driver.play();
        verify(out).println("Game is a draw!");
    }

}