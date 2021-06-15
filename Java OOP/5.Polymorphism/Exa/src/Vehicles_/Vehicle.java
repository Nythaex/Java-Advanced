package Vehicles_;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class  Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;


    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;

    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }


    public String driving(double distance) {
        if (this.fuelQuantity>=distance*fuelConsumption){
            this.fuelQuantity-=distance*fuelConsumption;
            DecimalFormat df=new DecimalFormat("0.##");
            return String.format("%s travelled %s km",this.getClass().getSimpleName(),df.format(distance));
        }
        return String.format("%s needs refueling",this.getClass().getSimpleName());
    }

    public void refueling(double extraFuel) {
        this.fuelQuantity+=extraFuel;
    }


}
