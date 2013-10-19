package Handle;

import java.io.IOException;
import java.io.ObjectInputStream;

public class Field {
    private static final char CROSS = 'x';
    private static final char TOE = 'o';
    private static char[][] field = new char[3][3];

    public char[][] getFields(){
        return field;
    }
    public void setField(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                field[i][j] = ' ';
            }
        }
    }
    public void viewField(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print("[" + field[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static void turnFromServer(int height, int wider){
        field[height][wider] = CROSS;
    }
    public static void turnFromClient(int height, int wider){
        field[height][wider] = TOE;
    }

    public static void requestFromServer(ObjectInputStream in){
        try {
            field = (char[][])in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
