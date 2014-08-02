package com.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IOHandlerTest {

    private BufferedReader reader;
    private PrintStream out;
    private IOHandler handler;

    @Before
    public void setUp(){
        reader = mock(BufferedReader.class);
        out = mock(PrintStream.class);
        handler = new IOHandler(reader, out);
    }

    @Test
    public void shouldReturn5WhenUserInputs5() throws IOException {
        when(reader.readLine()).thenReturn("5");

        assertThat(handler.getUserInput(), is("5"));
    }


    //TODO: Add tests for print and println, if out should be private
}