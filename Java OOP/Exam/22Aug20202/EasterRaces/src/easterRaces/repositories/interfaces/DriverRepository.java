package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DriverRepository implements Repository<Driver> {
    private Map<String,Driver> data;

    public DriverRepository() {
        data=new LinkedHashMap<>();
    }

    @Override
    public Driver getByName(String name) {
        return data.get(name);
    }

    @Override
    public Collection<Driver> getAll() {
        return data.values();
    }

    @Override
    public void add(Driver model) {
        data.put(model.getName(),model);
    }

    @Override
    public boolean remove(Driver model) {
        if (data.containsKey(model.getName())){
            data.remove(model.getName());
            return  true;
        }else{
            return false;
        }
    }
}
