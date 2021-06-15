package Vehicles_Extension;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption,double capacity) {
        super(fuelQuantity, fuelConsumption+0.9,capacity);
    }

}
