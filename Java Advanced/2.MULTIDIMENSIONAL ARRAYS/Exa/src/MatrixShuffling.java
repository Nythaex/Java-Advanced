import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++) {

            matrix[i] = scanner.nextLine().split("\\s+");

        }
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            if (tokens[0].equals("swap")&&tokens.length==5) {
                int firstRow = Integer.parseInt(tokens[1]);
                int firstCol = Integer.parseInt(tokens[2]);
                int secondRow = Integer.parseInt(tokens[3]);
                int secondCol = Integer.parseInt(tokens[4]);
                if (firstRow >= 0 && firstRow < matrix.length && firstCol >= 0 && firstCol < matrix[0].length &&
                        secondRow >= 0 && secondRow < matrix.length && secondCol >= 0 && secondCol < matrix[0].length) {
                    String cont = matrix[secondRow][secondCol];
                    matrix[secondRow][secondCol] = matrix[firstRow][firstCol];
                    matrix[firstRow][firstCol] = cont;
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int a = 0; a <= matrix[i].length - 1; a++) {
                System.out.print(matrix[i][a]+" ");
            }
            System.out.println();
        }
    }
}
