package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;
import easterRaces.entities.racers.Race;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class RaceRepository implements Repository<Race> {
    private Map<String, Race> data;

    public RaceRepository() {
        data=new LinkedHashMap<>();
    }

    @Override
    public Race getByName(String name) {
        return data.get(name);
    }

    @Override
    public Collection<Race> getAll() {
        return data.values();
    }

    @Override
    public void add(Race model) {
        data.put(model.getName(),model);
    }

    @Override
    public boolean remove(Race model) {
        if (data.containsKey(model.getName())){
            data.remove(model.getName());
            return  true;
        }else{
            return false;
        }
    }
}
