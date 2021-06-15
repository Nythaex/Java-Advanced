package Speed_Racing;

public class Car {
    private String model;
    private double fuelAmount;
    private double BurningFuelForKilometer;
    private int traveledDistance;

    public Car(String model,double fuelAmount,double burningFuelForKilometer){
        this.model=model;
        this.fuelAmount=fuelAmount;
        this.BurningFuelForKilometer=burningFuelForKilometer;
        this.traveledDistance=0;
    }
    public void doesTheCarCanMove(int kilometers){
        if (this.BurningFuelForKilometer*kilometers<=fuelAmount){
            this.fuelAmount-=this.BurningFuelForKilometer*kilometers;
            this.traveledDistance+=kilometers;
        }else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
    public String toString(){
        return String.format("%s %.2f %d",this.model,this.fuelAmount,this.traveledDistance);
    }

}
