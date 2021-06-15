package Raw_Data;

public class Car {
    private Cargo cargo;
    private Tire tire;
    private  Engine engine;

    public Car(Cargo cargo, Tire tire, Engine engine) {
        this.cargo = cargo;
        this.tire = tire;
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire getTire() {
        return tire;
    }

    public Engine getEngine() {
        return engine;
    }
}
