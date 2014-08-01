package com.twu;

/**
 * Created by hanlei on 7/31/14.
 */
public class Player {

    private int playerNum;
    private Board board;

    public Player(Board board, int playerNum) {
        this.board = board;
        this.playerNum = playerNum;
    }

    public void takeTurn(int position) {
        board.setPiece(position,this);
    }

    public int getPlayerNum() {
        return playerNum;
    }
}
