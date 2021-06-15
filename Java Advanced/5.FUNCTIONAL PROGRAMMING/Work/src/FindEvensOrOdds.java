import java.io.IOException;
import java.util.Scanner;
import java.util.function.BiPredicate;


public class FindEvensOrOdds {
    static BiPredicate<Integer, String> check = (num, type) -> {
        if (type.equals("odd")) {
            return num % 2 == 1;
        } else if (type.equals("even")) {
            return num % 2 == 0;
        }
        return false;
    };

    public static void main(String[] args)  {
        Scanner scanner=new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s+");
        String text = scanner.nextLine();
        findNumbers(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), text);


    }

    private static void findNumbers(int number, int end, String text) {
        for (int i = number; i <= end; i++) {
            if (check.test(i, text)) {
                System.out.print(i + " ");
            }
        }
    }
}
