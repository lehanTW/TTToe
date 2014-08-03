package com.twu;

/**
 * Created by hanlei on 7/31/14.
 */
public class Player {

    private String playerMarker;
    private Board board;

    public Player(Board board, String playerMarker) {
        this.board = board;
        this.playerMarker = playerMarker;
    }

    public boolean takeTurn(int position) {
        return board.setPiece(position,this);
    }

    public String getPlayerMarker() {
        return playerMarker;
    }
}
