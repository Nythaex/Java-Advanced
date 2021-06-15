package Vehicles_Extension;

import java.text.DecimalFormat;

public class Bus extends Vehicle{

    public Bus(double fuelQuantity, double fuelConsumption,double capacity) {
        super(fuelQuantity, fuelConsumption+1.4,capacity);
    }


}
