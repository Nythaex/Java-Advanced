package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] theSpace = creatingTheSpace(scanner);

        String command = scanner.nextLine();
        long IvoSPower = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoS = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            DestroyingTheSpace(theSpace, evil);
            IvoSPower = +GettingPower(theSpace, IvoSPower, ivoS);
            command = scanner.nextLine();
        }
        System.out.println(IvoSPower);
    }

    private static long GettingPower(int[][] matrix, long IvoSPower, int[] ivoS) {
        int xI = ivoS[0];
        int yI = ivoS[1];

        while (xI >= 0 && yI < matrix[1].length)
        {
            if ( xI < matrix.length && yI >= 0 && yI < matrix[0].length)
            {
                IvoSPower += matrix[xI][yI];
            }

            yI++;
            xI--;
        }
        return IvoSPower;
    }

    private static void DestroyingTheSpace(int[][] matrix, int[] evil) {
        int xE = evil[0];
        int yE = evil[1];

        while (xE >= 0 && yE >= 0)
        {
            if (xE < matrix.length && yE < matrix[0].length)
            {
                matrix[xE] [yE] = 0;
            }
            xE--;
            yE--;
        }
    }

    private static int[][] creatingTheSpace(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = dimensions[0];
        int y = dimensions[1];

        int[][] matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
}
