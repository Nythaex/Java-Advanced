package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.players.Player;

import java.util.*;

public class PlayerRepository implements Repository<Player> {
    private Collection<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList();
    }

    @Override
    public Collection<Player> getModels() {
        return models;
    }

    @Override
    public void add(Player model) {
        if (model==null){
            throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_REPOSITORY);
        }
        models.add(model);
    }

    @Override
    public boolean remove(Player model) {
        if (models.contains(model)){
            models.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Player findByName(String name) {
        return models.stream().filter(s->s.getUsername().equals(name)).findFirst().orElse(null);
    }
}
