package Clone.Commands;

import Clone.Container.Singleton.Addresses;
import Clone.Interfaces.Command;

public class RemoveCommand implements Command {
    @Override
    public String execute(String info) {
        Addresses addresses=Addresses.getInstance();
        addresses.getData().remove(info);
        return String.format("%s has been deleted!",info);
    }
}
