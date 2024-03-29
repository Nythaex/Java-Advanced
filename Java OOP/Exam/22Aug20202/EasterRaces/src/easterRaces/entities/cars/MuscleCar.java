package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;

public class MuscleCar extends BaseCar{
    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, 5000);
        if (horsePower<400||horsePower>600){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER,horsePower));
        }
    }
}
