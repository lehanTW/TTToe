package com.twu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        Board board = new Board(System.out);
        Player player1 = new Player(board,"X");
        Player player2 = new Player(board,"O");
        Decider decider = new Decider(board);
        AIPlayer aiPlayer1 = new AIPlayer(board,"X",decider);
        AIPlayer aiPlayer2 = new AIPlayer(board,"O",decider);

        InputHandler handler = new InputHandler(new BufferedReader(new InputStreamReader(System.in)));

        Game driver = new Game(handler, System.out, board, player1, player2);
        driver.play();
    }
}