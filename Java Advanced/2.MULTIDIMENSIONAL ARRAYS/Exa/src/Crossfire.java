package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        List<List<Integer>> matrix=new ArrayList<>();
        int d = 1;
        for (int i = 0; i < dim[0]; i++) {
            matrix.add(new ArrayList<>());
            for (int a = 0; a < dim[1]; a++) {
                matrix.get(i).add(d);

                d++;
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int[] tokens = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int radius = tokens[2];
            int rows = tokens[0];
            int cols = tokens[1];
            for (int i = rows - radius; i <= rows + radius; i++) {
                if (isInRange(i,cols,matrix)&&i!=rows) {
                    matrix.get(i).remove(cols);
                }
            }
            for (int i = cols + radius; i >=cols- radius; i--) {
                if (isInRange(rows,i,matrix)) {
                    matrix.get(rows).remove(i);
                }
            }


            matrix.removeIf(List::isEmpty);
            command=scanner.nextLine();
        }

        for(List<Integer> integers : matrix){
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}
