package Vehicles_Extension;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption,double capacity) {
        super(fuelQuantity, fuelConsumption+1.6,capacity);
    }

    @Override
    public void refueling(double extraFuel) {
        super.refueling(extraFuel*0.95);
    }
}
