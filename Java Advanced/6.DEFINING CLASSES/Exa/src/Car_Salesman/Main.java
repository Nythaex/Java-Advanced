package Car_Salesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        Map<String,Engine> engines=new HashMap<>();
        List<Car> cars=new LinkedList<>();
        int count=Integer.parseInt(reader.readLine());
        for (int i = 0; i <count; i++) {
            String[] tokens=reader.readLine().split("\\s+");
            String model = "";
            String power=null;
            if (tokens.length>=2){
                model=tokens[0];
                power=tokens[1];
            }
            Engine engine=null;
            if (tokens.length==2){
                engine=new Engine(model,power);
            }else if (tokens.length==4){
                String displacement=tokens[2];
                String efficiency=tokens[3];
                 engine=new Engine(model,power,displacement,efficiency);
            }else if (tokens.length==3){
                String additional=tokens[2];
                engine=new Engine(model,power,additional);

            }
            engines.putIfAbsent(model,engine);
        }
        //
        count=Integer.parseInt(reader.readLine());
        for (int i = 0; i <count; i++) {
            String[] tokens=reader.readLine().split("\\s+");
            String carModel=tokens[0];
            String engineModel=tokens[1];
            Car car=null;
            if (tokens.length==2){
                car=new Car(carModel,engines.get(engineModel));
            }else if (tokens.length==4){
                String weight=tokens[2];
                String color=tokens[3];
                car=new Car(carModel,engines.get(engineModel),weight,color);
            }else if (tokens.length==3){
                String additional=tokens[2];
                    car=new Car(carModel,engines.get(engineModel),additional);

            }
            cars.add(car);
        }
        cars.forEach(s-> System.out.println(s.toString()));








    }


}
