package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;

public class SportsCar  extends BaseCar{
    public SportsCar(String model, int horsePower) {
        super(model, horsePower,3000);
        if (horsePower<250||horsePower>450){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER,horsePower));
        }

    }

}
