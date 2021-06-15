package Border_Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Robot> IdsRobots = new ArrayList<>();
        List<Citizen> IdsCities = new ArrayList<>();
        AddingIds(reader,IdsCities,IdsRobots);
        String fakeId=reader.readLine();
        printingFakesIds(IdsCities,IdsRobots,fakeId);

    }

    private static void printingFakesIds(List<Citizen> idsCities, List<Robot> idsRobots,String fakeId) {
        printCitizens(idsCities, fakeId);
        printRobots(idsRobots, fakeId);
    }

    private static void printCitizens(List<Citizen> idsCities, String fakeId) {
        for (Citizen citizen: idsCities
             ) {
            if (citizen.getId().endsWith(fakeId)){
                System.out.println(citizen.getId());
            }
        }
    }

    private static void printRobots(List<Robot> idsRobots, String fakeId) {
        for (Robot robot: idsRobots
        ) {
            if (robot.getId().endsWith(fakeId)){
                System.out.println(robot.getId());
            }
        }
    }

    private static void AddingIds(BufferedReader reader,List<Citizen> citizens,List<Robot>robots) throws IOException {
        String command= reader.readLine();
        while(!command.equals("End")){
            String[] token = command.split("\\s+");
            if (token.length==3){
                Citizen citizen=new Citizen(token[0],Integer.parseInt(token[1]),token[2]);
                citizens.add(citizen);
            }else {
                Robot robot=new Robot(token[0],token[1]);
                robots.add(robot);
            }
            command= reader.readLine();
        }
    }
}
