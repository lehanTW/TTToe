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
    protected final int[][] winConditions = new int[][] {
            {1,2,3},{1,4,7},{7,8,9},{3,6,9},{1,5,9},{3,5,7},{4,5,6},{2,5,8}
    };

    protected final int[] corners = new int[] {1, 3, 7, 9};

    private void setUpGameBoard(){
        for(int i=0; i<=9; i++) {
            gameBoard.add(null);
        }
    }

    public Board(PrintStream out) {
        this.out = out;
        setUpGameBoard();
    }

    private String resolveSymbol(Player player){
        if(player == null){
            return " ";
        }
        return player.getPlayerMarker();
    }

    public void printBoard(){
        out.print(
                " "+ resolveSymbol(gameBoard.get(1))+" | "+ resolveSymbol(gameBoard.get(2))+" | "+ resolveSymbol(gameBoard.get(3))+" \n" +
                "-----------\n" +
                " "+ resolveSymbol(gameBoard.get(4))+" | "+ resolveSymbol(gameBoard.get(5))+" | "+ resolveSymbol(gameBoard.get(6))+" \n" +
                "-----------\n" +
                " "+ resolveSymbol(gameBoard.get(7))+" | "+ resolveSymbol(gameBoard.get(8))+" | "+ resolveSymbol(gameBoard.get(9))+" \n"
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
                gameBoard.get(winConditions[i][0]).equals(gameBoard.get(winConditions[i][1])) &&
                gameBoard.get(winConditions[i][1]).equals(gameBoard.get(winConditions[i][2]))){
                    return true;
            }
        }
        return false;
    }
}
