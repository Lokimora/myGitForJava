package Enemy;

import Handle.Checking;
import Handle.Field;
import Input.Data;

import Online.Server;


public class NetworkBattle {
    private static int whoIsTurn = 2;
    public static void gameBetweenHumans(){
        Field myFields = new Field();
        Server myServer = new Server();
        Data myData = new Data();
        while(true){
            if(whoIsTurn % 2 == 0){
                System.out.println("Your turn to play");
                myData.dataInput();
                myFields.viewField();
                Server.requestToClient(myFields.getFields());

            } else {
                System.out.println("Player two is turn to play");
                Server.requestFromClient();
                int height = Server.getHeight();
                int wider = Server.getWider();
                Field.turnFromClient(height, wider);
                myFields.viewField();

            }
            if(Checking.checkWinner(myFields.getFields())){
                System.out.println("Game if over");
                Server.closeTheServerSocket();
                break;
            }
            whoIsTurn++;
        }
    }
}
