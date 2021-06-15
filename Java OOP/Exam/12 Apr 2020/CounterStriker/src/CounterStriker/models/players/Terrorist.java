package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

public class Terrorist extends PlayerImpl{
    public Terrorist(String username, int health, int armor, Gun gun) {
        super(username, health, armor, gun,"Terrorist");
    }
    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("Terrorist: %s",getUsername())).append(System.lineSeparator());
        builder.append(String.format("--Health: %d",getHealth())).append(System.lineSeparator());
        builder.append(String.format("--Armor: %d",getArmor())).append(System.lineSeparator());
        builder.append(String.format("--Gun: %s",getGun().getName())).append(System.lineSeparator());
        return builder.toString();
    }
}
