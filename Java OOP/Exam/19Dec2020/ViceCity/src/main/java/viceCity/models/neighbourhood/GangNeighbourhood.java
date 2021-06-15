package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Collection<Gun> mainPlayerGuns = mainPlayer.getGunRepository().getModels();

        Deque<Gun> mainPlayerGunsDeque = new ArrayDeque<>();
        mainPlayerGuns.forEach(mainPlayerGunsDeque::offer);


        if (!mainPlayerGunsDeque.isEmpty()) {
            Gun gun = mainPlayerGunsDeque.poll();
            for (Player civilPlayer : civilPlayers) {
                while (gun.canFire()) {
                    while (civilPlayer.isAlive()) {
                        civilPlayer.takeLifePoints(gun.fire());
                        if (!gun.canFire()) {
                            if (!mainPlayerGunsDeque.isEmpty()) {
                                gun = mainPlayerGunsDeque.poll();
                            } else {
                                break;
                            }
                        }
                    }
                    if (!civilPlayer.isAlive()){
                        break;
                    }
                }

            }
        }


        for (Player civilPlayer : civilPlayers) {
            if (mainPlayer.isAlive()) {
                Collection<Gun> enemyGuns = civilPlayer.getGunRepository().getModels();
                Deque<Gun> enemyGunsDeque = new ArrayDeque<>(enemyGuns);
                enemyGuns.forEach(enemyGunsDeque::offer);

                while (!enemyGunsDeque.isEmpty()) {
                    Gun enemyGun = enemyGunsDeque.poll();
                    while (enemyGun.canFire()) {
                        mainPlayer.takeLifePoints(enemyGun.fire());
                        if (!mainPlayer.isAlive()) {
                            break;
                        }
                    }


                }
            }
        }


    }
}