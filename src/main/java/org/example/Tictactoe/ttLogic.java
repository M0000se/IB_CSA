package org.example.Tictactoe;

import java.util.Scanner;

public class ttLogic {
    private char[][] board = new char[3][3];
    private char player = 'X';
    private int turn = 0;

    private Scanner in = new Scanner(System.in);
    ttLogic(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length ; j++) {
                board[i][j] = ' ';
            }
        }
    }
    private boolean placeAndCheckValidity(int x, int y){
        // x and y should be in range 0-2
        if(x>2 || x<0)  return false;
        if(y>2 || y<0)  return false;
        if (board[y][x]!=' ') return false;
        board[y][x] = player;
        turn++;
        return true;
    }

    private void changePlayer(){
        if (player == 'X'){
            player = 'O';
        }
        else{
            player = 'X';
        }
    }
    private void printBoard()
    {
        System.out.println("   0   1   2");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" ");
                System.out.print(board[i][j]);
                if (j < board[i].length - 1){
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (i < board.length - 1){
                System.out.println("  -----------");
            }
        }
    }
    private boolean checkWin(){
        if (turn < 5)return false;
        for (int i = 0; i < board.length; i++) {
            if ((board[i][0]==board[i][1]) && (board[i][1]==board[i][2]) && (board[i][0]!=' ')){
                return true;
            }
            if ((board[0][i]==board[1][i]) && (board[1][i]==board[2][i]) && (board[0][i]!=' ')){
                return true;
            }
        }
        if ((board[0][0]==board[1][1]) && (board[1][1]==board[2][2]) && (board[0][0]!=' ')){
            return true;
        }
        if ((board[0][2]==board[1][1]) && (board[1][1]==board[2][0]) && (board[0][2]!=' ')){
            return true;
        }
        return false;
    }
    void run(){
        while (!checkWin() && turn < 9) {
            printBoard();
            System.out.println("Player " + player + " turn");
            System.out.println("Enter x coordinate:");
            int x = Integer.parseInt(in.nextLine());
            System.out.println("Enter y coordinate:");
            int y = Integer.parseInt(in.nextLine());
            System.out.println();
            if(!placeAndCheckValidity(x,y)) {
                System.out.println("!! Invalid Move !!");
                continue;
            }
            changePlayer();
        }
        if(!checkWin()) //if no-one won at the end
        {
            System.out.println("TIE");
            System.out.println("--------------------------");
        }
        else
        {
            printBoard();
            changePlayer();
            ttGameLoop.addScore(player);
            System.out.println("PLAYER " + player + " WINS");
            System.out.println("--------------------------");
        }
    }
}
