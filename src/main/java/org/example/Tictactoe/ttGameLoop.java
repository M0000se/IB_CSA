package org.example.Tictactoe;

public class ttGameLoop {
    static int p1score=0;
    static int p2score=0;
    public ttGameLoop(){
        while(true) {
            ttLogic ttLogic = new ttLogic();
            ttLogic.run();
            System.out.println("player 1     player 2");
            System.out.println(p1score+"            "+p2score);
            System.out.println();
        }
    }
    protected static void addScore(char player){
        if(player=='X') p1score++;
        else p2score++;
    }
}
