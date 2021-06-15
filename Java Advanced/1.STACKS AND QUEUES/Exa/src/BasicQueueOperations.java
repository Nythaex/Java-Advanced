import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rules = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= rules[0] - 1; i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 0; i <= rules[1] - 1; i++) {
            if (!queue.isEmpty()) {
                queue.poll();
            }
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(rules[2])){
                System.out.println(true);
            }else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}

