import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<Integer> numbers=new ArrayDeque<>();
        String [] array=scanner.nextLine().split(" ");
        numbers.push(Integer.valueOf(array[0]));
        for (int i = 1; i <= array.length - 1; i++) {
            if (array[i].equals("+"))
            {
                int numb=numbers.peek()+Integer.parseInt(array[i+1]);
                numbers.push(numb);
            }else if (array[i].equals("-")) {
                int numb=numbers.peek()-Integer.parseInt(array[i+1]);
                numbers.push(numb);
            }
        }
        System.out.println(numbers.peek());

    }
}
