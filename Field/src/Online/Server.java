package Online;

import Handle.Field;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import Handle.Checking;

public class Server {
    private static ObjectOutputStream objectOutputStream;
    private ServerSocket serverSocket;
    private static Socket acceptableSocket;
    private static InputStream inputStream ;
    private static OutputStream outputStream;
    private static int height = 0;
    private static int wider = 0;


    public Server(){
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Ожидание подключения клиента...");
            acceptableSocket = serverSocket.accept();
            System.out.println("Подключение удалось.");
            objectOutputStream = new ObjectOutputStream(acceptableSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void requestToClient(Object a){
        try {
            objectOutputStream.writeObject(a);
            objectOutputStream.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void requestFromClient() {
        try {
            inputStream = acceptableSocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            int[] buffMas = new int[2];
            height = dataInputStream.read();
            wider = dataInputStream.read();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getHeight(){
        return height;
    }
    public static int getWider(){
        return wider;
    }

    public static void closeTheServerSocket(){
        try {
            acceptableSocket.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }



}
