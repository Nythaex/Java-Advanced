package Vehicles_Extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));
        tokens = reader.readLine().split("\\s+");
        Vehicle truck=new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));
        tokens = reader.readLine().split("\\s+");
        Vehicle bus = new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));


        int commandsCount = Integer.parseInt(reader.readLine());

        vehiclesDo(reader, car, truck,bus, commandsCount);
        printLitersLeft(car, truck,bus);

    }

    private static void printLitersLeft(Vehicle car, Vehicle truck,Vehicle bus) {
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f%n", bus.getFuelQuantity());
    }

    private static void vehiclesDo(BufferedReader reader, Vehicle car,Vehicle truck,Vehicle bus, int commandsCount) throws IOException {
        String[] tokens;
        for (int i = 0; i < commandsCount; i++) {
            tokens = reader.readLine().split("\\s+");
            double parameter=Double.parseDouble(tokens[2]);
            switch (tokens[1]) {
                case "Car":
                    DriveOrRefuel(car, tokens, parameter);
                    break;
                case "Truck":
                    DriveOrRefuel(truck, tokens, parameter);
                    break;
                case "Bus":
                    DriveOrRefuel(bus, tokens, parameter);
                    break;
            }
        }
    }

    private static void DriveOrRefuel(Vehicle vehicle, String[] tokens, double parameter) {
        switch (tokens[0]) {
            case "Drive":
                System.out.println(vehicle.driving(parameter));
                break;
            case "Refuel":
                vehicle.refueling(parameter);
                break;
            case "DriveEmpty":
                System.out.println(vehicle.driving(parameter,true));
                break;
        }
    }
}
