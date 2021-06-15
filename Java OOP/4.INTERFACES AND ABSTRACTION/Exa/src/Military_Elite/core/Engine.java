package Military_Elite.core;

import Military_Elite.Soldiers.Creator.SoldierCreator;
import Military_Elite.Soldiers.PrivateImpl;
import Military_Elite.Soldiers.SoldierImpl;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Engine {
    public void run() throws IOException {
        String command= reader.readLine();
        while(!command.equals("End")){
            String []tokens=command.split("\\s+");
            try {
                SoldierImpl soldier= SoldierCreator.createSoldier(tokens);
                System.out.println(soldier.toString());
            }catch (IllegalArgumentException exception){
            }
            command= reader.readLine();
        }


    }




    private static Engine instance;
    private static boolean initialize = false;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private Engine() {
    }

    public static Engine getInstance() {
        if (!initialize) {
            instance = new Engine();
            initialize = true;
        }
        return instance;
    }
}
