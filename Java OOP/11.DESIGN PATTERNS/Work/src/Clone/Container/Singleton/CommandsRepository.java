package Clone.Container.Singleton;

import Clone.Interfaces.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandsRepository {
    private static CommandsRepository instance;
    private Map<String,Command> commandsRepository;

    private CommandsRepository() {
        commandsRepository=new HashMap<>();
    }

    public static CommandsRepository getInstance() {
        CommandsRepository instance = new CommandsRepository();
        return instance;
    }
     public void registerCommand(String commandName,Command command){
        commandsRepository.putIfAbsent(commandName,command);
    }
    public Command getCommand(String commandName){
        return commandsRepository.get(commandName);
    }

}
