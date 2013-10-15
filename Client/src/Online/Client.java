package Online;
import Graphics.*;
import java.net.*;
import java.io.*;
import Online.Serial;

import java.net.Socket;

public class Client {
    public static void main(String[] args){

        try {
            InetAddress thisAddress = InetAddress.getByName("127.0.0.1");
            Socket clientSocket = new Socket(thisAddress, 800);

            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();

            DataInputStream input = new DataInputStream(is);
            DataOutputStream output = new DataOutputStream(os);
            char[][] fields = new char[3][3];
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            String fuser = null;
            while(true) {
                System.out.println("Your turn to play");
                for(int i = 0; i < 2; i++) {
                    fuser = buff.readLine();
                    output.writeUTF(fuser);
                }
                for(int j = 0; j < 2; j++) {
                    Serial object = (Serial) ois.readObject();
                    fields = object.getMassive();
                    Views.seen(fields);
                }

            }



        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
