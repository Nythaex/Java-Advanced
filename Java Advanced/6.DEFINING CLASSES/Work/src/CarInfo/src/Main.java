import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Car> carList = new ArrayList<>();
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            String[] tokens=reader.readLine().split(" ");

            if (tokens.length==1){
                Car newCar=new Car(tokens[0]);
                carList.add(newCar);
            }else {
                Car newCar=new Car(tokens[0],tokens[1],Integer.parseInt(tokens[2]));
                carList.add(newCar);
            }
        }
        for (Car car:carList
             ) {
            System.out.println(car.printString());
        }
    }
}
