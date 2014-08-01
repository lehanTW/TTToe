package com.twu;

import java.io.*;

/**
 * Created by hanlei on 7/30/14.
 */
public class GameDriver {

    protected Board board;
    private PrintStream out;
    private InputStream in;

    public GameDriver(PrintStream out, InputStream in){
        board = new Board(out);
        this.out = out;
        this.in = in;

    }

    public String getUserInput(InputStream in) {
        String inputLn = "";
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(in));
            inputLn = is.readLine();
            if(inputLn.length() == 0){
                return null;
            }
        } catch (IOException e){
            System.out.println("IOException: "+e);
        }

        return inputLn;
    }

    public void play(){

        int turn = 0;
        int playersTurn = 0;
        while(!board.boardIsFull()){
            turn++;

            if(turn%2 == 1){
                playersTurn = 1;
            } else if (turn%2 == 0) {
                playersTurn = 2;
            }

            board.printBoard();
            out.print("Player "+playersTurn+" make a move: ");
            String userInput = getUserInput(in);

            /*while(!board.setPiece(Integer.parseInt(userInput), playersTurn)){
                out.println("Location Already Taken!");
                out.print("Player "+playersTurn+" make a move: ");
                userInput = getUserInput(in);
            }*/
        }

        if(board.boardIsFull()){
            board.printBoard();
            out.println("Game is a draw!");
        }

    }

}
