import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int[][] theBoard = new int[count][];
        int[][] finale = new int[count][];
        for (int i = 0; i < theBoard.length; i++) {
            String d=scanner.nextLine();
            int[] col = Arrays.stream(d.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] cole = Arrays.stream(d.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            theBoard[i] = col;
            finale[i] = cole;
        }
        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int wrongValue = theBoard[indexes[0]][indexes[1]];
        for (int i = 0; i <= theBoard.length - 1; i++) {
            for (int a = 0; a <= theBoard[i].length - 1; a++) {
                if (theBoard[i][a] == wrongValue) {
                    int sum = 0;
                    if (i - 1 >= 0) {
                        if (theBoard[i - 1][a] != wrongValue) {
                            sum += theBoard[i - 1][a];
                        }
                    }
                    if (i + 1 < theBoard.length) {
                        if (theBoard[i + 1][a] != wrongValue) {
                            sum += theBoard[i + 1][a];
                        }
                    }
                    if (a - 1 >= 0) {
                        if (theBoard[i][a - 1] != wrongValue) {
                            sum += theBoard[i][a - 1];
                        }
                    }
                    if (a + 1 < theBoard[i].length) {
                        if (theBoard[i][a + 1] != wrongValue) {
                            sum += theBoard[i][a + 1];
                        }
                    }
                    finale[i][a]=sum;
                }
            }
        }
        printMatrix(finale);
    }

    private static void printMatrix(int[][] theBoard) {
        for (int i = 0; i <= theBoard.length - 1; i++) {
            for (int a = 0; a <= theBoard[i].length - 1; a++) {
                System.out.print(theBoard[i][a]+" ");
            }
            System.out.println();
        }
    }
}
