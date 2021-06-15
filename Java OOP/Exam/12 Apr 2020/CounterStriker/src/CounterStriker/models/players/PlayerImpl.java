package CounterStriker.models.players;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;
    private String type;

    @Override
    public String getType() {
        return type;
    }

    public PlayerImpl(String username, int health, int armor, Gun gun, String type) {
        setName(username);
        setHealth(health);
        setArmor(armor);
        setGun(gun);
        checkIsAlive(health);
        this.type=type;
    }

    private void checkIsAlive(int health) {
        if (health <= 0) {
            isAlive = false;
        } else {
            isAlive = true;
        }

    }

    private void setName(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public Gun getGun() {
        return gun;
    }

    @Override
    public boolean isAlive() {
        checkIsAlive(health);
        return isAlive;
    }


    @Override
    public void takeDamage(int points) {

        if (this.armor == 0) {
            health -= points;
        } else {
            if (armor >= points) {
                this.armor -= points;
            } else {
                int armorBreak = points - armor;
                this.health -= armorBreak;
            }
            if (health <= 0) {
                isAlive = false;
            }
        }
    }
}
