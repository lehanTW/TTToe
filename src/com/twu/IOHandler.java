package com.twu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by hanlei on 8/2/14.
 */
public class IOHandler {


    private BufferedReader reader;
    private PrintStream out;

    public IOHandler(BufferedReader reader, PrintStream out) {
        this.reader = reader;
        this.out = out;
    }

    public String getUserInput() {
        String inputLn = "";
        try {
            inputLn = reader.readLine();
            if (inputLn.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            out.println("IOException: " + e);
        }
        return inputLn;
    }

    public void print(String str){
        this.out.print(str);
    }

    public void println(String str){
        this.out.println(str);
    }
}
