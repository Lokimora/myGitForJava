package Online;

import java.io.*;
public class Serial implements Serializable{
    private char[][] mas;
    public Serial(char[][] mas) {
        this.mas = mas;
        mas = new char[3][3];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
            }
        }
    }
    public char[][] getMassive(){
        return mas;
    }
}