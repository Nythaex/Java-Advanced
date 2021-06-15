package Valid_Person;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("Kiro","Ivanov",-1);
        } catch (InvalidPersonNameException | IllegalArgumentException e) {
            System.out.println("Exception thrown: "+e.getMessage());
        }
    }
}
