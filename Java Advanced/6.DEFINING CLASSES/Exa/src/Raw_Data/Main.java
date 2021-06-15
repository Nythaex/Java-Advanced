package Raw_Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        Map<String,Car> cars=new LinkedHashMap<>();
        int n=Integer.parseInt(reader.readLine());
        for (int i = 0; i <n; i++) {
            String []tokens=reader.readLine().split("\\s+");
            Engine engine=new Engine(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
            Cargo cargo=new Cargo(Integer.parseInt(tokens[3]),tokens[4]);
            Tire tire=new Tire(Double.parseDouble(tokens[5]),Double.parseDouble(tokens[7]),Double.parseDouble(tokens[9]),Double.parseDouble(tokens[11]),
                    Integer.parseInt(tokens[6]),Integer.parseInt(tokens[8]),Integer.parseInt(tokens[10]),Integer.parseInt(tokens[12]));
            Car car=new Car(cargo,tire,engine);
            cars.put(tokens[0],car);
        }
        String type=reader.readLine();

        cars.entrySet().stream().filter(s->s.getValue().getCargo().check(type,s.getValue().getTire(), s.getValue().getEngine()))
                .forEach(print-> System.out.println(print.getKey()));
    }
}
