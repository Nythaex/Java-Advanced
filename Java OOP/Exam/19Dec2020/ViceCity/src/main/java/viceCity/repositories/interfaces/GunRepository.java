package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.*;

public class GunRepository implements Repository<Gun>{
    private Map<String,Gun> models;

    public GunRepository() {
        this.models =new LinkedHashMap<>();
    }

    @Override
    public Collection getModels() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Gun model) {
         models.putIfAbsent(model.getName(),model);
    }

    @Override
    public boolean remove(Gun model) {
        boolean removed=models.containsKey(model.getName());
        if (removed){
            models.remove(model.getName());
        }
       return removed;
    }

    @Override
    public Gun find(String name) {
        return models.get(name);
    }

}
