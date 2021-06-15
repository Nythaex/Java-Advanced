import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        int startRow = matrix.length - 1;
        int startCol = matrix[startRow].length - 1;
        while (true) {
            if (startCol == 0 && startRow == 0) {
                System.out.println(matrix[0][0]);
                break;
            }
            int row = startRow;
            int col = startCol;
            while (row >=0 && col < matrix[row].length) {
                System.out.print(matrix[row][col]+" ");
                row--;
                col++;
            }
            System.out.println();

            if (startCol - 1 < 0) {
                startRow--;
            } else {
                startCol--;
            }
        }

    }
}
