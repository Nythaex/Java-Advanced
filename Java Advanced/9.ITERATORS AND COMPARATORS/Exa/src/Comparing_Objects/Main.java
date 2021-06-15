package Comparing_Objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        String command = reader.readLine();
        int matched = 0;
        int nonematched = 0;
        int townCount;
        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            people.add(person);
            command = reader.readLine();
        }
        int p = Integer.parseInt(reader.readLine());
        for (int i = 0; i < people.size(); i++) {
            if (i != p - 1) {
                if (people.get(i).compareTo(people.get(p - 1)) == 0) {
                    if (matched==0){
                        matched++;
                    }
                    matched++;
                } else {
                    nonematched++;
                }
            }
        }
        if (matched == 0) {
            System.out.println("No matches");
        } else {
            System.out.print(matched + " " + nonematched + " ");
            System.out.println(matched + nonematched);
        }

    }


}
