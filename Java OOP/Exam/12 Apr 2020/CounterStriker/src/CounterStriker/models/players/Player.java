package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

public interface Player {
    String getUsername();

    int getHealth();

    int getArmor();

    Gun getGun();

    String getType();

    boolean isAlive();

    void takeDamage(int points);
}
