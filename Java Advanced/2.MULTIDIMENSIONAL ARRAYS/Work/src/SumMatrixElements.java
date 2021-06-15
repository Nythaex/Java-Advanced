import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int sum=0;
        int[] rowsAndColons = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] theArray = new int[rowsAndColons[0]][];
        for (int i = 0; i <= theArray.length - 1; i++) {
            theArray[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            sum+= Arrays.stream(theArray[i]).sum();
        }
        System.out.println(rowsAndColons[0]);
        System.out.println(rowsAndColons[1]);
        System.out.println(sum);

    }
}
