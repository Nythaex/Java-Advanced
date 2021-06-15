package OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        List<Person> people=new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String [] tokens=reader.readLine().split(" ");
            Person person = new Person(tokens[0],Integer.parseInt(tokens[1]));
            people.add(person);
        }
        people.stream().filter(p->p.getAge()>30).sorted(Comparator.comparing(Person::getName)).forEach(p-> System.out.println(p.toString()));

    }

}
