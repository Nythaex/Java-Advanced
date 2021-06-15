package TrafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String []tokens=reader.readLine().split("\\s+");
        int updates =Integer.parseInt(reader.readLine());
        List<TrafficLight> trafficLights=new ArrayList<>();
        for (int i = 0; i <tokens.length; i++) {
            TrafficLight light=new TrafficLight(Lights.valueOf(tokens[i]));
            trafficLights.add(light);
        }
        for (int i = 0; i < updates; i++) {
            trafficLights.forEach(s->{
                s.update();
                System.out.print(s.getState()+" ");
            });
            System.out.println();
        }


    }
}
