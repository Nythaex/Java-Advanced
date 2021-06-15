import java.util.Scanner;

public class FilltheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(", ");
        int[][] matrix = fillTheMatrix(Integer.parseInt(tokens[0]), tokens[1]);
        printMatrix(matrix);
        ;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int a = 0; a <= matrix[i].length - 1; a++) {
                System.out.print(matrix[i][a]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] fillTheMatrix(int parseInt, String token) {
        int[][] matrix = new int[parseInt][parseInt];
        if (token.equals("A")) {
            int i=1;
            for (int row = 0; row <= parseInt - 1; row++) {
                for (int col = 0; col <= parseInt - 1; col++) {
                    matrix[col][row]=i;
                            i++;
                }
            }
            return matrix;
        } else if (token.equals("B")) {
            int i=1;
            int colls=1;
            for (int row = 0; row <= parseInt - 1; row++) {
                if (colls%2==1) {
                    for (int col = 0; col <= parseInt - 1; col++) {
                        matrix[col][row] = i;
                        i++;
                    }
                }else {
                    for (int col = parseInt-1; col >= 0; col--) {
                        matrix[col][row] = i;
                        i++;
                    }
                }
                colls++;
            }
            return matrix;
        }
        return matrix;
    }
}
