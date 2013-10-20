package Input;
import java.io.*;

import Online.Server;
import Handle.Field;
import Handle.Checking;

public class Data {
    private static int height;
    private static int wider;
    private static BufferedReader inputBuff = new BufferedReader(new InputStreamReader(System.in));
    private Field myFields = new Field();
    public void dataInput(){
        try {
            while(true)
            {
                try{
                    height  = Integer.parseInt(inputBuff.readLine());
                    wider   = Integer.parseInt(inputBuff.readLine());
                    break;
                } catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                }

            }
            while(true)
            {
                if(Checking.checkIndex(height, wider) && Checking.checkForEmpty(myFields.getFields(), height, wider )){
                    break;
                } else {
                    while(true)
                    {
                        System.out.println("Illegal arguments. Please enter your coordinates again");
                        try{
                            height  = Integer.parseInt(inputBuff.readLine());
                            wider   = Integer.parseInt(inputBuff.readLine());
                            if(Checking.checkIndex(height, wider) && Checking.checkForEmpty(myFields.getFields(), height, wider ))
                            break;

                        } catch (NumberFormatException e){
                            System.out.println(e.getMessage());
                        }

                    }
                }
            }
            Field.turnFromServer(height, wider);
        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

}
