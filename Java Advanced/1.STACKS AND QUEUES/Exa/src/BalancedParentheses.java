import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char [] AllSymbols =scanner.nextLine().toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean check = true;
        for (int i = 0; i < AllSymbols.length; i++) {
            switch (AllSymbols[i]) {
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '(':
                    stack.push(')');
                    break;
                case ' ':
                    stack.push(' ');
                    break;
                case '}':
                case ']':
                case ')':
                    if (stack.isEmpty() || stack.pop()!=(AllSymbols[i])) {
                        check = false;
                    }
                    break;
                default:
                    break;
            }
        }
        if (!check) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
