package com.twu;

import java.io.*;

/**
 * Created by hanlei on 7/30/14.
 */
public class Game {

    protected Board board;
    private PrintStream out;
    private BufferedReader reader;
    private Player player1;
    private Player player2;

    public Game(PrintStream out, BufferedReader reader, Board board, Player player1, Player player2){
        this.board = board;
        this.out = out;
        this.reader = reader;
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getUserInput() {
        String inputLn = "";
        try{
            inputLn = reader.readLine();
            if(inputLn.length() == 0){
                return null;
            }
        } catch (IOException e){
            out.println("IOException: "+e);
        }

        return inputLn;
    }

    public void play(){

        boolean player1Turn = true;

        while(!board.boardIsFull()){
            Player currentPlayer;
            int playerNum = 1;

            if(player1Turn){
                currentPlayer = player1;
                playerNum = 1;
            } else {
                currentPlayer = player2;
                playerNum = 2;
            }

            board.printBoard();
            out.print("Player "+playerNum+" make a move: ");
            String userInput = getUserInput();

            while(!currentPlayer.takeTurn(Integer.parseInt(userInput))){
                out.println("Location Already Taken!");
                out.print("Player "+playerNum+" make a move: ");
                userInput = getUserInput();
            }

            if(board.gameIsWon()){
                board.printBoard();
                out.println("Player "+playerNum+" Wins!");
                return;
            }

            player1Turn = !player1Turn;
        }

        out.println("Game is a draw!");

    }

}
