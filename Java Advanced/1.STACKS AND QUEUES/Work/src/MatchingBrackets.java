import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        String seq=scanner.nextLine();
        String [] array=seq.split("");
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i].equals("(")){
                stack.push(i);
            }else if (array[i].equals(")")) {
                String ne=seq.substring(stack.pop(),i+1);
                System.out.println(ne);
            }
        }

    }
}
