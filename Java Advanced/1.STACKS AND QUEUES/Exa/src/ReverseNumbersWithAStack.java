import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] a = scanner.nextLine().split(" ");
        for (int i = 0; i <= a.length - 1; i++) {
            stack.push(a[i]);
        }
        for (int i = 0; i <= a.length - 1; i++) {
            System.out.print(stack.pop()+" ");
        }
    }
}
