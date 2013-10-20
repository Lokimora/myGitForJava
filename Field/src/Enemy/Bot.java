package Enemy;

import Handle.*;
import Input.Data;
import Online.Server;

import java.math.*;
import java.util.Random;

public class Bot {
    static int height;
    static int wider;
    private static int whoIsTurn = (int) (1 + Math.random() * 3);
    public static void turnFromBot(){
        Field myFields = new Field();
        Data myData = new Data();
        while(true){
            if(whoIsTurn % 2 == 0){
                System.out.println("Your tun to play");
                myData.dataInput();
                myFields.viewField();

            } else {
                System.out.println("Computer is turn to play");
                height =  (int) (0 + Math.random() * 3);
                wider  =  (int) (0 + Math.random() * 3);

                while(true)
                {
                    if(Checking.checkIndex(height, wider) && Checking.checkForEmpty(myFields.getFields(), height, wider )){
                        break;
                } else {
                        height = (int) (0 + Math.random() * 3);
                        wider =  (int) (0 + Math.random() * 3);
                }
                }
                Field.turnFromBot(height, wider);
                myFields.viewField();

            }
            if(Checking.checkWinner(myFields.getFields())){
                System.out.println("Game is over");
                break;
            }
            if(whoIsTurn >= 11){
                System.out.println("Standoff");
                break;
            }
            whoIsTurn++;
    }
}
}
