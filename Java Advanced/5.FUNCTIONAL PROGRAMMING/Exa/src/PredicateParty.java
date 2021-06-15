import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> people = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        String command = reader.readLine();
        while (!command.equals("Party!")) {
            String[] tokens = command.split("\\s+");
            String theCommand = tokens[0];
            String does = tokens[1];
            String have = tokens[2];
            Predicate<String> check = name -> {
                switch (does) {
                    case "StartsWith":
                        if (name.startsWith(have)) {
                            return true;
                        }
                        break;
                    case "EndsWith":
                        if (name.endsWith(have)) {
                            return true;
                        }
                        break;
                    case "Length":
                        int lenght = Integer.parseInt(have);
                        if (name.length() == lenght) {
                            return true;
                        }
                        break;
                }
                return false;
            };
            switch (theCommand) {
                case "Remove":
                    removeThem(check, people);
                    break;
                case "Double":
                    doubleThem(check, people);
                    break;

            }
            command = reader.readLine();
        }
        Collections.sort(people);
        if (people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            System.out.println(String.join(", ", people)+" are going to the party!");
        }


    }

    private static void removeThem(Predicate<String> check, List<String> people) {
        people.removeIf(check);
    }

    private static void doubleThem(Predicate check, List<String> people) {
        int size = people.size();
        for (int i = 0; i <= size - 1; i++) {
            if (check.test(people.get(i))) {
                people.add(people.get(i));
            }
        }
    }
}
