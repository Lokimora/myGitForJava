package Online;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import Handle.Field;
import Handle.Checking;

public class Client {
    private static int height;
    private static int wider;
    private static Socket clientSocket;
    private static InputStream inputStream ;
    private static OutputStream outputStream;
    private static BufferedReader outBuff = new BufferedReader(new InputStreamReader(System.in));;
    private static String input = null;
    private static Field myFields = new Field();

    public Client(){
        try {
            clientSocket = new Socket("localhost", 4444);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void requestToServer(){
        try {

            outBuff = new BufferedReader(new InputStreamReader(System.in));
            outputStream = clientSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            System.out.println("U Turn to play");

            while(true)
            {
                try{
                    height = Integer.parseInt(outBuff.readLine());
                    wider  = Integer.parseInt(outBuff.readLine());
                    break;
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }

            while(true){
                if(Checking.checkIndex(height, wider) && Checking.checkForEmpty(myFields.getFields(), height, wider)){
                    break;
                } else {

                    while(true)
                    {
                        try{
                            height = Integer.parseInt(outBuff.readLine());
                            wider  = Integer.parseInt(outBuff.readLine());
                            break;
                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }

                    }
                }
            }
                dataOutputStream.write(height);
                dataOutputStream.write(wider);
            Field myField = new Field();
            Field.turnFromClient(height,wider);
            myField.viewField();
            System.out.println();



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void requestFromServer(ObjectInputStream objectInputStream){
        try {
            Field.requestFromServer(objectInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ObjectInputStream createThread(){
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            return objectInputStream;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectInputStream = null;
    }

    public static void closeTheSocket(){
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


}
