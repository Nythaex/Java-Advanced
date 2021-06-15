import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String,Long>> countries = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("report")) {
            String[] tokens = command.split("\\|");
            String country = tokens[1];
            String city = tokens[0];
            long population = Integer.parseInt(tokens[2]);
            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).put(city, population);

            command = scanner.nextLine();
        }
        countries.entrySet().stream().sorted((s1, s2) -> {
            long first = s1.getValue().values().stream().mapToLong(l->l).sum();
            long second = s2.getValue().values().stream().mapToLong(l->l).sum();
            return Long.compare(second, first);
        }).forEach(s -> {
            System.out.printf("%s (total population: %d)%n", s.getKey(), s.getValue().values().stream().mapToLong(l->l).sum());
            Map<String, Long> value = s.getValue();
            value.entrySet().stream().sorted((z,w)->Long.compare(w.getValue(), z.getValue()))
                    .forEach(print->System.out.printf("=>%s: %d%n",print.getKey(),print.getValue()));
        });

    }
}
