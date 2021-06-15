package Car_Salesman;

public class Car {
    private String carModel;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String carModel, Engine engine, String weight, String color) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String carModel, Engine engine, String color) {
        this(carModel, engine, color.matches("^\\d+$")?color:"n/a",color.matches("^\\d+$")?"n/a":color);
    }

    public Car(String carModel, Engine engine) {
        this(carModel, engine, "n/a", "n/a");
    }
    public String toString(){
        return this.carModel+String.format(":%n")+this.engine.toString()+String.format("Weight: %s%nColor: %s",this.weight,this.color);
    }
}
