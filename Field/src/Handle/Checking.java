package Handle;

import java.io.*;

public class Checking {
    private static boolean result;
    private static BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    static final char KREST = 'x';
    static final char NOLIK = 'o';

    public static boolean checkWinner(char[][] myMassive){

        for(int i = 0; i < 3; i++){
            if(myMassive[i][0] == myMassive[i][1] && myMassive[i][1] == myMassive[i][2] && (myMassive[i][2] == KREST || myMassive[i][2] == NOLIK)) {
                if(myMassive[i][0] == KREST){
                    System.out.println("U win");
                    return true;
                } else {
                    System.out.println("U lose");
                    return true;
                }
            } else if(myMassive[0][i] == myMassive[1][i] && myMassive[1][i] == myMassive[2][i] && (myMassive[2][i] == KREST || myMassive[2][i] == NOLIK)){
                if(myMassive[0][i] == KREST) {
                    System.out.println("U win");
                    return true;
                } else {
                    System.out.println("U lose");
                    return true;
                }
            }
        }
        if(myMassive[0][0] == myMassive[1][1] && myMassive[1][1] == myMassive[2][2] && (myMassive[2][2] == KREST || myMassive[2][2] == NOLIK) ){
            if(myMassive[0][0] == KREST) {
                System.out.println("U win");
                return true;
            } else {
                System.out.println("U lose");
                return true;
            }
        } else if(myMassive[0][2] == myMassive[1][1] && myMassive[1][1] == myMassive[2][0] && (myMassive[2][0] == KREST || myMassive[2][0] == NOLIK)){
            if(myMassive[0][2] == KREST) {
                System.out.println("U win");
                return true;
            } else {
                System.out.println("U lose");
                return true;
            }
        }
        return false;
    }

    public static boolean checkIndex(int height, int wider){
        while(true){
            if((height >= 0 && height < 3) && (wider >= 0 && wider < 3))
            {
                return true;
            } else {
                return false;
            }
        }

    }

    public static boolean checkForEmpty(char myMassive[][], int height, int wider){
        while(true){
            try{
                String str = String.valueOf(myMassive[height][wider]);

                if(str.equals("x") || str.equals("o")){
                    return false;
                } else {
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException e){
                return false;
            }

        }
}

}