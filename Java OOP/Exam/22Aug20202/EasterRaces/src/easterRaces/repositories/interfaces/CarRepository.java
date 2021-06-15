package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarRepository implements Repository<Car> {
    private Map<String,Car> data;

    public CarRepository() {
        data=new LinkedHashMap<>();
    }

    @Override
    public Car getByName(String name) {
        return data.get(name);
    }

    @Override
    public Collection<Car> getAll() {
        return data.values();
    }

    @Override
    public void add(Car model) {
     data.put(model.getModel(),model);
    }

    @Override
    public boolean remove(Car model) {
        if (data.containsKey(model.getModel())){
            data.remove(model.getModel());
            return  true;
        }else{
            return false;
        }
    }
}
