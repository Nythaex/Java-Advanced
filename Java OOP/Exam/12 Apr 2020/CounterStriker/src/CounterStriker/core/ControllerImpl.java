package CounterStriker.core;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.common.OutputMessages;
import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;
import CounterStriker.repositories.Repository;

import java.util.Collection;

public class ControllerImpl implements Controller {
    private Repository<Gun> gunRepository;
    private Repository<Player> playersRepository;
    private Field field;

    public ControllerImpl() {
        this.gunRepository = new GunRepository();
        this.playersRepository = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        if (type.equals("Pistol")) {
            gunRepository.add(new Pistol(name, bulletsCount));
        } else if (type.equals("Rifle")) {
            gunRepository.add(new Rifle(name, bulletsCount));
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_TYPE);
        }

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        if (gunRepository.findByName(gunName) == null) {
            throw new NullPointerException(ExceptionMessages.GUN_CANNOT_BE_FOUND);
        }
        Gun playerGun = gunRepository.findByName(gunName);

        if (type.equals("Terrorist")) {
            playersRepository.add(new Terrorist(username, health, armor, playerGun));
        } else if (type.equals("CounterTerrorist")) {
            playersRepository.add(new CounterTerrorist(username, health, armor, playerGun));
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }


        return String.format(OutputMessages.SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return field.start(playersRepository.getModels());
    }


    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        playersRepository.getModels().stream().sorted((s1, s2) -> {
            if (s1.getType().equals(s2.getType())) {
                if (s1.getHealth() == s2.getHealth()) {
                    return s1.getUsername().compareTo(s2.getUsername());
                }
                return Integer.compare(s2.getHealth(),s1.getHealth());
            }
            return s1.getType().compareTo(s2.getType());
        }).forEach(s-> builder.append(s.toString()));

        return builder.toString().trim();
    }
}
