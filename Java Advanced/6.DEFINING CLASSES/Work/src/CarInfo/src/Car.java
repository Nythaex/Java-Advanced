public class Car {
   private String branch;
   private String model;
   private int km;

    public Car(String branch) {
        this.branch = branch;
        this.model = "unknown";
        this.km = -1;
    }

    public Car(String branch, String model,int km) {
        this.branch = branch;
        this.model = model;
        this.km = km;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKm() {
        return km;
    }

    public void setKm (int km) {
        this.km = km;
    }
    public String printString(){
        return  String.format("The car is: %s %s - %d HP.",this.branch,this.model,this.km);
    }
}
