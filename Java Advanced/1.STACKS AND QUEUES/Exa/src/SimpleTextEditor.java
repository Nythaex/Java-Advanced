import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            switch (tokens[0]) {
                case "1":
                    text.append(tokens[1]);
                    stack.push(String.valueOf(text));
                    break;
                case "2":
                    int start= text.length()-Integer.parseInt(tokens[1]);
                    text.delete(start,text.length());
                    stack.push(String.valueOf(text));
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(tokens[1]) - 1));
                    break;
                case "4":
                    stack.pop();
                    if (!stack.isEmpty()) {
                        text = new StringBuilder(stack.peek());
                        break;
                    }
            }

        }
        System.out.println();
    }
}
