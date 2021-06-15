package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GunRepository implements Repository<Gun>{
    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList();
    }
    @Override
    public Collection<Gun> getModels() {
       return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Gun model) {
        if (model==null){
            throw new NullPointerException(ExceptionMessages.INVALID_GUN_REPOSITORY);
        }
        models.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        if (models.contains(model)){
            models.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Gun findByName(String name) {
        Gun gun=models.stream().filter(s->s.getName().equals(name)).findFirst().orElse(null);
        return gun;
    }
}
