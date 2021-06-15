package hierarchy;

public class Vehicle {
    final static double DEFAULT_FUEL_CONSUMPTION=1.25;
    protected double fuelConsumption;
    protected double fuel;
    protected int horsePower;

    public Vehicle( double fuel, int horsePower) {
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
        this.fuel = fuel;
        this.horsePower = horsePower;
    }

    public static double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void  drive (double kilometers){
        setFuel(this.getFuel()>=kilometers*this.getFuelConsumption()
                ?this.getFuel()-kilometers*this.getFuelConsumption()
                :this.getFuel());
    }

}
