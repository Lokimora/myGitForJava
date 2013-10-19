package Main;

import Online.Client;
import Handle.Field;
import Handle.Checking;

import java.io.EOFException;
import java.io.ObjectInputStream;


public class MainClass {

    private static int height;
    private static int wider;

    public static void main(String[] args)throws EOFException{
        Field myField = new Field();
        Client myClient = new Client();
        ObjectInputStream myStream = Client.createThread();
            boolean a = true;
            while(a){
            Client.requestFromServer(myStream);
            myField.viewField();
            Client.requestToServer();
            if(Checking.checkWinner(myField.getFields()))
                {
                    a = false;
                }

        }

    }
}
