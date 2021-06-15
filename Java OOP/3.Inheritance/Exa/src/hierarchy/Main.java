package hierarchy;

public class Main {
    public static void main(String[] args) {
        FamilyCar sportCar=new FamilyCar(30,23);
        sportCar.drive(10);
        System.out.println(sportCar.getFuel());
    }

}
