import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols =Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCols[0];
        int col = rowsAndCols[1];
        int[][] first = new int[rows][];
        for (int i = 0; i <= rows - 1; i++) {
            int[] colForTheRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            first[i]=colForTheRow;
        }
        int[] rowsAndColSecond =Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rowsS = rowsAndColSecond[0];
        int colS = rowsAndColSecond[1];
        int[][] second = new int[rowsS][];
        for (int i = 0; i <= rowsS - 1; i++) {
            int[] colForTheRow =Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            second[i]=colForTheRow;
        }

        boolean are = areThey(first, second);
        System.out.println(are ? "equal" : "not equal");

    }

    private static boolean areThey(int[][] first, int[][] second) {
        boolean areThey = true;
        if (first.length != second.length) {
            return false;
        } else {
            for (int rows = 0; rows <= first.length - 1; rows++) {
                if (first[rows].length != second[rows].length) {
                    return false;
                }
                for (int col = 0; col <= first[rows].length - 1; col++) {
                    if (first[rows][col] != second[rows][col]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
