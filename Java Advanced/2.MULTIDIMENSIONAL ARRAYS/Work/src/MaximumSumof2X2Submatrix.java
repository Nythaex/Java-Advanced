import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumof2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndColons = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] theArray = new int[rowsAndColons[0]][];
        for (int i = 0; i <= theArray.length - 1; i++) {
            theArray[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] matrix = new int[2][2];
        int sum = Integer.MIN_VALUE;
        for (int rows = 0; rows <= theArray.length - 2; rows++) {
            for (int cols = 0; cols <= theArray[rows].length - 2; cols++) {
                if (sum < theArray[rows][cols] + theArray[rows][cols + 1] + theArray[rows + 1][cols] + theArray[rows + 1][cols + 1]) {
                    sum = theArray[rows][cols] + theArray[rows][cols + 1] + theArray[rows + 1][cols] + theArray[rows + 1][cols + 1];
                    matrix[0][0] = theArray[rows][cols];
                    matrix[0][1] = theArray[rows][cols + 1];
                    matrix[1][0] = theArray[rows + 1][cols];
                    matrix[1][1] = theArray[rows + 1][cols + 1];
                }
            }
        }
        System.out.println(matrix[0][0]+" "+matrix[0][1]);
        System.out.println(matrix[1][0]+" "+matrix[1][1]);
        System.out.println(sum);
    }
}
