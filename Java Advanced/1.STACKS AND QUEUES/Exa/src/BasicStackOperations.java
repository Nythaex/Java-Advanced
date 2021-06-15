import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rules = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= rules[0] - 1; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i <= rules[1] - 1; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        int lowest = MAX_VALUE;
        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            while (!stack.isEmpty()) {
                if (stack.peek() == rules[2]) {
                    System.out.println(true);
                    return;
                }
                if (lowest > stack.peek()) {
                    lowest = stack.peek();
                }
                stack.pop();
            }
            System.out.println(lowest);
        }
    }
}
