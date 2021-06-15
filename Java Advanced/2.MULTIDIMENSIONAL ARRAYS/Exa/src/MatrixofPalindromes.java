import java.util.Arrays;
import java.util.Scanner;

public class MatrixofPalindromes {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] ArraySize= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String [][] matrix=new String[ArraySize[0]][ArraySize[1]];
        char chary='a';
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int a= 0; a <= matrix[i].length - 1; a++) {
                matrix[i][a]=String.format("%c%c%c ",chary,chary+a,chary);
            }
            chary++;
        }
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int a= 0; a <= matrix[i].length - 1; a++) {
                System.out.print(matrix[i][a]);
            }
            System.out.println();
        }

    }
}
