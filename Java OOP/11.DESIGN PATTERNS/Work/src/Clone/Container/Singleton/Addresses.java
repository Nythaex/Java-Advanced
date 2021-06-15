package Clone.Container.Singleton;

import Clone.Interfaces.Clone;
import Clone.Modules.Address;

import java.util.HashMap;
import java.util.Map;

public class Addresses implements Clone<Address> {
    private static Map<String, Address> data;
    private static Addresses instance;




    public Addresses() {
        data = new HashMap<>();
    }

    public Map<String, Address> getData() {
        return data;
    }

    public  static Addresses getInstance() {
        instance=new Addresses();
        return instance;
    }

    @Override
    public Address clone(String key) {
        Address copy=data.get(key);
        Address newOne=new Address();
        newOne.setName(copy.getName()).setSex(copy.getSex()).setAge(copy.getAge());
        return newOne;
    }
}
