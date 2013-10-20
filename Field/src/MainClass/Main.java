package MainClass;

import java.io.*;

import Enemy.Bot;
import Enemy.NetworkBattle;


import java.io.ObjectOutputStream;

public class Main {

    public static int whoIsTurn = 2;

    public static void main(String args[])throws  IOException{

        System.out.println("Welcome to the tic-tac-toe. If u wanna play with player on Network - enter 0, if u wanna play with computer -  enter 1");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.parseInt(bufferedReader.readLine());

        switch (choice){
            case 0:
                NetworkBattle.gameBetweenHumans();
                break;
            case 1:
                Bot.turnFromBot();
                break;
        }


    }
}
