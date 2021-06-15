import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int[] ArraySize = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[][] matrix = new boolean[ArraySize[0]][ArraySize[1]];
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int a = 0; a <= matrix[i].length - 1; a++) {
                matrix[i][a] = true;
            }
        }

        String command = bufferedReader.readLine();
        while (!command.equals("stop")) {
            int distance = 0;
            int[] tokens = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (!matrix[tokens[1]][tokens[2]] || tokens[2] == 0) {
                boolean free = false;
                int enter = tokens[0];
                for (int i = 1; i <= matrix[tokens[1]].length  - 1; i++) {
                    if (tokens[2] - i > 0) {
                        if (matrix[tokens[1]][tokens[2] - i] && tokens[2] - i > 0) {
                            matrix[tokens[1]][tokens[2] - i] = false;
                            System.out.println(Math.abs(tokens[0] - tokens[1]) + tokens[2] - i + 1);
                            free = true;
                            break;
                        }
                    }
                    if (tokens[2] + i < matrix[tokens[1]].length) {
                        if (matrix[tokens[1]][tokens[2] + i]) {
                            matrix[tokens[1]][tokens[2] + i] = false;
                            System.out.println(Math.abs(tokens[0] - tokens[1]) + tokens[2] + i + 1);
                            free = true;
                            break;
                        }
                    }
                }
                if (!free) {
                    System.out.printf("Row %d full%n", tokens[1]);
                }
            } else {
                matrix[tokens[1]][tokens[2]] = false;
                distance = Math.abs(tokens[1] - tokens[0]) + tokens[2] + 1;
                System.out.println(distance);
            }

            command = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}
