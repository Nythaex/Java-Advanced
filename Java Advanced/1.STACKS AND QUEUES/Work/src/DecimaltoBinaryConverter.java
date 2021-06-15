import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimaltoBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        int n=Integer.valueOf(scanner.nextLine());
        if(n==0){
            System.out.println(0);
            return;
        }
        while(n!=1){
            stack.push(n%2);
            n/=2;
        }
        System.out.print(1);
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }
}
