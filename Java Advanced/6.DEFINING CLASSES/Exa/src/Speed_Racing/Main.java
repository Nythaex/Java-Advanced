package Speed_Racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Map<String, Car> carCollection = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String carModel = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelPerKM = Double.parseDouble(tokens[2]);
            Car car = new Car(carModel, fuelAmount, fuelPerKM);
            carCollection.put(carModel, car);
        }
        String command = reader.readLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            if (tokens[0].equals("Drive")){
             carCollection.get(tokens[1]).doesTheCarCanMove(Integer.parseInt(tokens[2]));
            }
            command = reader.readLine();
        }
        carCollection.values().forEach(s-> System.out.println(s.toString()));
    }
}
