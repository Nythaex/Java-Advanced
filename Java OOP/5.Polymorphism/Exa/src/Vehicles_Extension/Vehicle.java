package Vehicles_Extension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double tankCapacity;

    public void setFuelQuantity(double fuelQuantity) {
        if (CheckFuelNumber(fuelQuantity)) {
            return;
        }
        this.fuelQuantity = fuelQuantity;
    }

    private boolean CheckFuelNumber(double fuelQuantity) {
        if (fuelQuantity<=0){
            System.out.println("Fuel must be a positive number");
            return true;
        }
        return false;
    }

    public Vehicle(double fuelQuantity, double fuelConsumption,double capacity) {
        setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = capacity;

    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }


    public String driving(double distance) {
        return drive(distance,0);
    }

    private String drive(double distance, double extraConsumption) {
        double consumption=this.fuelConsumption-extraConsumption;
        if (this.fuelQuantity>=distance*fuelConsumption){
            this.fuelQuantity-=distance*fuelConsumption;
            DecimalFormat df=new DecimalFormat("0.##");
            return String.format("%s travelled %s km",this.getClass().getSimpleName(),df.format(distance));
        }
        return String.format("%s needs refueling",this.getClass().getSimpleName());
    }

    public String driving(double distance,boolean empty) {
        return drive(distance,1.4);
    }
    public void refueling(double extraFuel) {
        if (CheckFuelNumber(extraFuel)) {
            return;
        }
        if (this.fuelQuantity+extraFuel>this.tankCapacity){
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        this.fuelQuantity+=extraFuel;
    }


}
