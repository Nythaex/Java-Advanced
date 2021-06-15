import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] kids = scanner.nextLine().split(" ");
        int potato= Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <= kids.length - 1; i++) {
            queue.offer(kids[i]);
        }
        while (queue.size()!=1){
            for (int i = 1; i <= potato-1; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed "+queue.poll());
        }
        System.out.println("Last is "+queue.poll());
    }
}
