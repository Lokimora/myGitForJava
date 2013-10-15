package demo.uml;

import Graphics.Views;
import demo.uml.CheckingForWinner;
import demo.uml.Player;
import Online.Server;
import java.io.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainClass{
    public static int RANDOM = 1;
    public static char KREST = 'x';
    public static char NOLIK = 'o';

    public static void main(String[] args) throws IOException{
        System.out.println("Ожидание подключения клиента;");
        ServerSocket serverSocket = new ServerSocket(800);
        Socket acceptableSocket = serverSocket.accept();
        //Sockets
        InputStream is = acceptableSocket.getInputStream();
        OutputStream os = acceptableSocket.getOutputStream();
        //Threads
        DataInputStream input = new DataInputStream(is);
        DataOutputStream output = new DataOutputStream(os);
        //Threads
        ObjectOutputStream oos = new ObjectOutputStream(acceptableSocket.getOutputStream());
        //ThreadsMassive

        char[][] myFields = new char[3][3];
        while(true){
            if(RANDOM == 10)
                break;
            if(RANDOM % 2 != 0){
                System.out.println("Ходит первый игрок");
                if(Server.ServerFunc(myFields,input)){ //проверяю корректность вводимых данных
                    Server.reMassive(myFields, oos); // Передаю массив клиенту
                    Views.seen(myFields); //просто вывожу поле в консоль
                } else{
                    while(true){
                       if(Server.ServerFunc(myFields,input)){
                           Server.reMassive(myFields, oos);
                           Views.seen(myFields);
                           break;
                       }
                    }
                }
            } else {
                System.out.println("Ходит второй игрок");
                myFields = CheckingForAvailable(myFields, NOLIK); //ввод данных и проверка на коректность
                Views.seen(myFields);
                Server.reMassive(myFields, oos); //передаю массив клиенту
            }
            if(CheckingForWinner.checkWinner(myFields)) {
                break;
            }
            RANDOM++;
        }
        System.out.println("Игра закончилась");

    }

    public static char[][] CheckingForAvailable(char[][]myMassive, char symbol) throws IOException{
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите координаты клетки. Нумерация начинается с 0 до 2.");
        int height = Integer.parseInt(buff.readLine());
        int wider = Integer.parseInt(buff.readLine());
        String str;
        while(true){
            if(Player.checkForEmpty(myMassive, height, wider) && Player.checkIndex(height, wider)){
                myMassive[height][wider] = symbol;
                return myMassive;
            }
            else{
                height = Integer.parseInt(buff.readLine());
                wider = Integer.parseInt(buff.readLine());
            }
        }

    }
}
      /*222*/
