package com.twu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        Board board = new Board(System.out);
        Player player1 = new Player(board,"X");
        Player player2 = new Player(board,"O");
        IOHandler handler = new IOHandler(new BufferedReader(new InputStreamReader(System.in)), System.out);

        Game driver = new Game(handler, board, player1, player2);
        driver.play();
    }
}