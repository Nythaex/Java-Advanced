package Clone.Commands;

import Clone.Container.Singleton.Addresses;
import Clone.Interfaces.Command;
import Clone.Modules.Address;

public class AddCommand implements Command {
    @Override
    public String execute(String info) {
        Addresses addresses=Addresses.getInstance();
        String [] addressInfo=info.split(", ");
        String name=addressInfo[0];
        int age=Integer.parseInt(addressInfo[1]);
        String sex=addressInfo[2];
        addresses.getData().put(info,new Address().setName(name).setAge(age).setSex(sex));
        return String.format("%s has been added!",info);
    }
}
