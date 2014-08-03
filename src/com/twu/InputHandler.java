package com.twu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by hanlei on 8/2/14.
 */
public class InputHandler {


    private BufferedReader reader;

    public InputHandler(BufferedReader reader) {
        this.reader = reader;
    }

    public String getUserInput() {
        String inputLn = "";
        try {
            inputLn = reader.readLine();
            if (inputLn.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLn;
    }
}
