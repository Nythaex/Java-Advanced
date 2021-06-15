package Google_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        Person person= null;
        Map<String, Person> people = new HashMap<>();
        while (!command.equals("End")) {
            String []tokens=command.split("\\s+");
            if (!people.containsKey(tokens[0])){
                person=new Person(tokens[0]);
                people.put(tokens[0],person);
            }
            switch (tokens[1]) {
                case "company":
                    Company company=new Company(tokens[2]+" "+tokens[3],Double.parseDouble(tokens[4]));
                    people.get(tokens[0]).setCompany(company);
                    break;
                case "car":
                    if (people.get(tokens[0]).getCar()==null){
                        Car car=new Car(tokens[2]+" "+tokens[3]);
                        people.get(tokens[0]).setCar(car);
                    }
                    break;
                case "pokemon":
                    people.get(tokens[0]).getPokemons().addPok(tokens[2]+" "+tokens[3]);
                    break;
                case "parents":
                    people.get(tokens[0]).getParents().addPok(tokens[2]+" "+tokens[3]);
                    break;
                case "children":
                    people.get(tokens[0]).getChildren().addPok(tokens[2]+" "+tokens[3]);
                    break;
            }
            command = reader.readLine();
        }
        String printer=reader.readLine();
        System.out.println(printer);
        System.out.println(people.get(printer).toSting());
    }
}
