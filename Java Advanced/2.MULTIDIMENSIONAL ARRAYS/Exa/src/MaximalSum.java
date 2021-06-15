package src;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] rowsAndColons = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] theArray = new int[rowsAndColons[0]][];
        for (int i = 0; i <= theArray.length - 1; i++) {
            theArray[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int rowM=-1;
        int colM=-1;
        int sum = Integer.MIN_VALUE;
        for (int rows = 0; rows <= theArray.length - 3; rows++) {
            for (int cols = 0; cols <= theArray[rows].length - 3; cols++) {
                if (sum < theArray[rows][cols] + theArray[rows][cols + 1] + theArray[rows ][cols+2] + theArray[rows + 1][cols]
               + theArray[rows + 1][cols+1]+ theArray[rows + 1][cols+2]+ theArray[rows + 2][cols]+ theArray[rows + 2][cols+1]+ theArray[rows + 2][cols+2]) {
                    sum =theArray[rows][cols] + theArray[rows][cols + 1] + theArray[rows ][cols+2] + theArray[rows + 1][cols]
                            + theArray[rows + 1][cols+1]+ theArray[rows + 1][cols+2]+ theArray[rows + 2][cols]+ theArray[rows + 2][cols+1]+ theArray[rows + 2][cols+2];
                    rowM=rows;
                    colM=cols;
                }
            }
        }
        System.out.println("Sum = "+sum);
        for (int i = rowM; i <rowM+3; i++) {
            for (int a = colM; a <colM+3; a++) {
                System.out.print(theArray[i][a]+" ");
            }
            System.out.println();
        }
    }
}
