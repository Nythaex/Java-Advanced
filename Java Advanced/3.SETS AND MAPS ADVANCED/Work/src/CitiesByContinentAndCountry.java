import java.nio.charset.StandardCharsets;
import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, LinkedList<String>>> world = new LinkedHashMap<>();
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String cont = tokens[0];
            String country = tokens[1];
            String city = tokens[2];
            world.putIfAbsent(cont, new LinkedHashMap<>());
            world.get(cont).putIfAbsent(country, new LinkedList<String>());
            world.get(cont).get(country).add(city);

        }
        world.entrySet()
                .forEach(cont -> {
                    System.out.println(cont.getKey() + ":");
                    cont.getValue().forEach((k, s) -> {
                        System.out.printf("%s -> %s%n", k, String.join(", ", s));
                    });
                });

        //world.forEach((key, value) -> {
        //            System.out.println(key + ":");
        //            value.forEach((k, s) -> {
        //                System.out.printf("%s -> %s%n", k, String.join(", ", s));
        //            });
        //        });
    }
}
