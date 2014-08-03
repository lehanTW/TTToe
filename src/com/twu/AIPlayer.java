package com.twu;

/**
 * Created by hanlei on 8/2/14.
 */
public class AIPlayer extends Player {

    private Decider decider;
    Board board;

    public AIPlayer(Board board, String playerMarker, Decider decider) {
        super(board, playerMarker);
        this.decider = decider;
    }



}
