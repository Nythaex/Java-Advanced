package Clone.Core;

import Clone.Commands.AddCommand;
import Clone.Commands.RemoveCommand;
import Clone.Container.Singleton.Addresses;
import Clone.Container.Singleton.CommandsRepository;

import java.io.*;

public class Engine {
    private static Engine instance;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); ;
    private BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
    private Engine() {
    }


    public void run() throws IOException {
        Addresses addresses=Addresses.getInstance();
        CommandsRepository commandsRepository=CommandsRepository.getInstance();
        commandsRepository.registerCommand("Add",new AddCommand());
        commandsRepository.registerCommand("Remove",new RemoveCommand());


        String input=reader.readLine();
        while(!input.equals("End")){
            String [] commandAndAddressInfo=input.split("-");
            String command = commandAndAddressInfo[0];
            String addressInfo=null;
            if (commandAndAddressInfo.length>1){
                 addressInfo = commandAndAddressInfo[1];
            }
            input=commandsRepository.getCommand(command).execute(addressInfo);
            if (input.equals("End")){
                break;
            }else {
                System.out.println(input);
            }
            input=reader.readLine();
        }



    }

    public static Engine getInstance() {
        Engine instance = new Engine();
        return instance;
    }
}
