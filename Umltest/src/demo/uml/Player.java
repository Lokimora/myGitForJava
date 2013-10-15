package demo.uml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    public static boolean checkForEmpty(char myMassive[][], int height, int wider){
        while(true){
            try{
                String str = String.valueOf(myMassive[height][wider]);

                if(str.equals("x") || str.equals("o")){
                    System.out.println("Ошибка: клетка занята. Введите еще раз.");
                    return false;
                } else {
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Ошибка: некоректные координаты. Введите еще раз.");
                return false;
            }

        }
    }

    public static boolean checkIndex(int height, int wider){
        if(height >= 0 && height < 3 && wider >=0 && wider < 3){
            return true;
        } else {
            System.out.println("Ошибка: некоректные координаты. Введите еще раз.");
            return false;
        }
    }
}
