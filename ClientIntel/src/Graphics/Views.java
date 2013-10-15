package Graphics;

public class Views {
    public static void seen(char[][] mas){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print("[" + mas[i][j] + "]");
            }
            System.out.println();
        }
    }
}
