package Vehicles_;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption+1.6);
    }

    @Override
    public void refueling(double extraFuel) {
        super.refueling(extraFuel*0.95);
    }
}
