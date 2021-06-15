package Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();

        Map<String, Person> people = new HashMap<>();
        while (!command.equals("End")) {
           Person person= new Person();
            String[] tokens = command.split("\\s+");
            people.putIfAbsent(tokens[0],person);
             people.get(tokens[0]).addInfo(tokens);
            command = reader.readLine();
        }
        String printer=reader.readLine();
        System.out.println(printer);
        System.out.println(people.get(printer).toSting());
    }
}
