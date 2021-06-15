import java.lang.reflect.Array;
import java.util.*;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = Integer.parseInt(scanner.nextLine());
        List<Long> numbers = new ArrayList<>();
        numbers.add(1L);
        numbers.add(1L);
        while (numbers.size() <= index) {
            numbers.add(numbers.get(numbers.size()-1)+numbers.get(numbers.size()-2));
        }
        System.out.println(numbers.get(numbers.size()-1));
    }
}
