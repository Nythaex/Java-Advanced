import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] kids = scanner.nextLine().split(" ");
        int potato= Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <= kids.length - 1; i++) {
            queue.offer(kids[i]);
        }
        int cycle=72;
        while (queue.size()>1){
            for (int i = 1; i <= potato-1; i++) {
                queue.offer(queue.poll());
            }
            if (cycle!=1&&(cycle%2!=0&&cycle%3!=0)||(cycle==2||cycle==3)){
                System.out.println("Prime "+queue.peek());

            }else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is "+queue.poll());
    }
}
