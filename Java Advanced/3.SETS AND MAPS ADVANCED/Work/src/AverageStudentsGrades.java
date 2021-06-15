import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            List<Double> adding = students.computeIfAbsent(tokens[0], k -> new ArrayList<>());
            adding.add(Double.parseDouble(tokens[1]));
        }

        for (Map.Entry<String, List<Double>> stringListEntry : students.entrySet()) {
            System.out.print(stringListEntry.getKey()+" -> ");
            for (double p:stringListEntry.getValue()
                 ) {
                System.out.printf("%.2f ",p);
            }
            System.out.println(String.format("(avg: %.2f)",averageF(stringListEntry.getValue())));
        }

    }

    private static double averageF(List<Double> marks) {
        Double sum = 0d;
        if(!marks.isEmpty()) {
            for (Double mark : marks) {
                sum += mark;
            }
            return sum.doubleValue() / marks.size();
        }
        return sum;

    }
}
