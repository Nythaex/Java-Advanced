import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        int n=Integer.parseInt(scanner.nextLine());
        int highestNum=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int [] tokens= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (tokens[0]==1){
                stack.push(tokens[1]);
                if (stack.peek()>highestNum){
                    highestNum=stack.peek();
                }
            }else if (tokens[0]==2){
                stack.pop();
            }else {
                System.out.println(Collections.max(stack));
            }
        }
    }

}
