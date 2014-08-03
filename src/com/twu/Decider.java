package com.twu;

/**
 * Created by hanlei on 8/3/14.
 */
public class Decider {


    private Board board;

    public Decider(Board board) {
        this.board = board;
    }

    public int goForNextEmpty() {
        int positionToPlay = -1;
        for(int i = 1; i < board.gameBoard.size(); i++){
            if(board.gameBoard.get(i) == null){
                positionToPlay = i;
                break;
            }
        }
        return positionToPlay;
    }

    public int goForWin(AIPlayer aiPlayer) {
        int positionToPlay = -1;

        for(int i=0; i<board.winConditions.length; i++){
            for(int j=0; j<board.winConditions[i].length; j++){
                if(
                    board.gameBoard.get(board.winConditions[i][(j+1) % board.winConditions[i].length]) ==
                            board.gameBoard.get(board.winConditions[i][(j+2)%3]) &&

                    board.gameBoard.get(board.winConditions[i][(j+1) % board.winConditions[i].length]) ==
                            aiPlayer
                  )
                {
                    positionToPlay = board.winConditions[i][j];
                }
            }
        }
        return positionToPlay;
    }

    public int block(AIPlayer aiPlayer){
        return -1;
    }
}
