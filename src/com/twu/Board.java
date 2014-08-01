package com.twu;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlei on 7/30/14.
 */
public class Board {

    private PrintStream out;
    protected final List<Player> gameBoard = new ArrayList<Player>();
    private final int[][] winConditions = new int[][] {
            {1,2,3},{1,4,7},{7,8,9},{3,6,9},{1,5,9},{3,5,7},{4,5,6},{2,5,8}
    };

    private void setUpGameBoard(){
        for(int i=0; i<=9; i++) {
            gameBoard.add(null);
        }
    }

    public Board(PrintStream out) {
        this.out = out;
        setUpGameBoard();
    }

    private String getPieceSymbol(Player player){
        if(player == null){
            return " ";
        } else if (player.getPlayerNum() ==1) {
            return "X";
        } else if (player.getPlayerNum() ==2) {
            return "O";
        }

        return "";
    }

    public void printBoard(){
        out.print(
                " "+getPieceSymbol(gameBoard.get(1))+" | "+getPieceSymbol(gameBoard.get(2))+" | "+getPieceSymbol(gameBoard.get(3))+" \n" +
                "-----------\n" +
                " "+getPieceSymbol(gameBoard.get(4))+" | "+getPieceSymbol(gameBoard.get(5))+" | "+getPieceSymbol(gameBoard.get(6))+" \n" +
                "-----------\n" +
                " "+getPieceSymbol(gameBoard.get(7))+" | "+getPieceSymbol(gameBoard.get(8))+" | "+getPieceSymbol(gameBoard.get(9))+" \n"
        );
    }

    public boolean setPiece(int position, Player player) {
        if(gameBoard.get(position)!=null){
            return false;
        }
        gameBoard.set(position, player);
        return true;
    }

    public Boolean boardIsFull() {

        for(int i = 1; i<=9; i++){
            if(gameBoard.get(i) == null){
                return false;
            }
        }
        return true;
    }

    public Boolean gameIsWon() {
        for(int i=0; i<winConditions.length; i++){
            if( gameBoard.get(winConditions[i][0]) != null &&
                gameBoard.get(winConditions[i][0]) == gameBoard.get(winConditions[i][1]) &&
                gameBoard.get(winConditions[i][1]) == gameBoard.get(winConditions[i][2])){
                    return true;
            }
        }
        return false;
    }
}
