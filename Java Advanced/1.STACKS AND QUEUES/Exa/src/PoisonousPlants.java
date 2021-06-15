import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int platsCount = Integer.parseInt(scanner.nextLine());
        String[] tokens = scanner.nextLine().split(" ");
        List<Integer> pesticide = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            pesticide.add(Integer.parseInt(tokens[i]));
        }
        int days = 0;
        while (true) {
            boolean alive = true;
            for (int i = pesticide.size() - 1; i >= 1; i--) {
                if (pesticide.get(i) > pesticide.get(i - 1)) {
                    pesticide.remove(i);
                    alive = false;
                }
            }
            if (alive == true) {
                break;
            }
            days++;
        }
        System.out.println(days);
    }
}
