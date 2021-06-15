package Raw_Data;

public class Tire {
    private  double tire1Pressure;
    private  double tire2Pressure;
    private  double tire3Pressure;
    private  double tire4Pressure;
    private int tire1Age;
    private int tire2Age;
    private int tire3Age;
    private int tire4Age;

    public Tire(double tire1Pressure, double tire2Pressure, double tire3Pressure,
                double tire4Pressure, int tire1Age, int tire2Age, int tire3Age, int tire4Age) {
        this.tire1Pressure = tire1Pressure;
        this.tire2Pressure = tire2Pressure;
        this.tire3Pressure = tire3Pressure;
        this.tire4Pressure = tire4Pressure;
        this.tire1Age = tire1Age;
        this.tire2Age = tire2Age;
        this.tire3Age = tire3Age;
        this.tire4Age = tire4Age;
    }
    public boolean checkFragile(){
        return tire1Pressure < 1 || tire2Pressure <1 || tire3Pressure < 1 || tire4Pressure < 1;
    }
}
