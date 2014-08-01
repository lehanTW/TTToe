package com.twu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        Board board = new Board(System.out);
        Player player1 = new Player(board,1);
        Player player2 = new Player(board,2);

        GameDriver driver = new GameDriver(System.out, new BufferedReader(new InputStreamReader(System.in)),board, player1, player2);
        driver.play();
    }
}