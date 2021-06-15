package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    MainPlayer mainPlayer;
    Map<String, Player> players;
    ArrayDeque<Gun> totalGuns;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.players = new HashMap<>();
        totalGuns = new ArrayDeque<>();
    }

    @Override
    public String addPlayer(String name) {
        CivilPlayer CivilPlayer = new CivilPlayer(name);
        players.putIfAbsent(name, CivilPlayer);
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        switch (type) {
            case "Pistol":
                totalGuns.offer(new Pistol(name));
                break;
            case "Rifle":
                totalGuns.offer(new Rifle(name));
                break;
            default:
                return ConstantMessages.GUN_TYPE_INVALID;

        }
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (totalGuns.isEmpty()) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        } else if (name.equals("Vercetti")) {
            Gun gun = totalGuns.poll();
            mainPlayer.getGunRepository().add(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), "Tommy Vercetti");
        } else if (!players.containsKey(name)) {

            return String.format(ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST);
        }
        Gun gun = totalGuns.poll();
        players.get(name).getGunRepository().add(gun);
        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER,gun.getName(),name);
    }

    @Override
    public String fight() {
        GangNeighbourhood fight =new GangNeighbourhood();
        var expected=players;
        fight.action(mainPlayer,players.values());
        boolean changed = false;
        long size= players.entrySet().stream().filter(s -> s.getValue().isAlive()).count();
        if (expected.size()==size){
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        }
        StringBuilder build=new StringBuilder();
        build.append(ConstantMessages.FIGHT_HAPPENED).append(System.lineSeparator());
        build.append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE,mainPlayer.getLifePoints())).append(System.lineSeparator());
        build.append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,expected.size()-size)).append(System.lineSeparator());
        build.append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE,size));

        return  build.toString();
    }
}
