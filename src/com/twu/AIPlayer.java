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

    public boolean takeTurn(){
        int positionToPlay = -1;

        positionToPlay = decider.goForWin(this);

        if(positionToPlay < 1){
            positionToPlay = decider.blockOpponent(this);
        }

        return super.takeTurn(positionToPlay);
    }

}
