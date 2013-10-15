package Online;


import java.io.*;

import demo.uml.Player;

import static java.lang.Integer.parseInt;

public class Server {

    public static boolean ServerFunc(char[][] massiveFields, DataInputStream input) {
        try {

            System.out.println("Waiting for response from client");
            int[] fields = new int[2];
            String str = null;
            for(int i = 0; i < 2; i++){
                str = input.readUTF();
                fields[i] = Integer.parseInt(str);
            }

            int height = fields[0];
            int wider = fields[1];
            if(Player.checkIndex(fields[0], fields[1]) && Player.checkForEmpty(massiveFields, fields[0], fields[1])){
                massiveFields[height][wider] = 'x';
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
            return false;
        }

    }
    public static void reMassive(char[][] Massive, ObjectOutputStream oos ){
        try {
            oos.writeObject(Massive);//отсылаю массив

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
