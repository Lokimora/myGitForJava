package MainClass;

import Online.Server;
import Handle.Field;
import Input.Data;
import Handle.Checking;

import java.io.ObjectOutputStream;

public class Main {

    public static int whoIsTurn = 2;

    public static void main(String args[]){
        Field myFields = new Field();
        Server myServer = new Server();
        Data myData = new Data();
        while(true){
            if(whoIsTurn % 2 == 0){
                System.out.println("Ваш ход");
                myData.dataInput();
                myFields.viewField();
                Server.requestToClient(myFields.getFields());

            } else {
                System.out.println("Ходит второй игрок");
                Server.requestFromClient();
                int height = Server.getHeight();
                int wider = Server.getWider();
                Field.turnFromClient(height, wider);
                myFields.viewField();

            }
            if(Checking.checkWinner(myFields.getFields())){
                System.out.println("Игра закончилась");
                Server.closeTheServerSocket();
                break;
            }
            whoIsTurn++;
        }
    }
}
