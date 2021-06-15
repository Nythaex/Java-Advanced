import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> people = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        Map<String, Predicate<String>> checker = new LinkedHashMap<>();
        String command = reader.readLine();
        while (!command.equals("Print")) {
            String[] tokens = command.split(";");
            switch (tokens[0]) {
                case "Add filter":
                    checker.put(tokens[1] + tokens[2], check(tokens[1], tokens[2]));
                    break;
                case "Remove filter":
                    if (checker.containsKey(tokens[1] + tokens[2])) {
                        checker.remove(tokens[1] + tokens[2]);
                    }
                    break;
            }
            command = reader.readLine();
        }
        people.stream().filter(person -> {
            boolean isIt = true;
            for (Predicate<String> value : checker.values()) {
                if (value.test(person)) {
                    isIt = false;
                    break;
                }
            }
            return isIt;
        }).forEach(s -> System.out.print(s + " "));

    }

    public static Predicate<String> check(String command, String para) {
        Predicate<String> checker = null;
        if (command.equals("Starts with")) {
           checker=s -> s.startsWith(para);
        } else if (command.equals("Ends with")) {
            checker=s -> s.endsWith(para);
        } else if (command.equals("Length")) {
            checker=s -> s.length() == Integer.parseInt(para);
        } else {
             checker=s -> s.contains(para);
        }
        return checker;
    }

}



