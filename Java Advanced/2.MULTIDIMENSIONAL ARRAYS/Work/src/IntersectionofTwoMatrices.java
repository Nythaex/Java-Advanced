import java.util.Arrays;
import java.util.Scanner;

public class IntersectionofTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int colons = Integer.parseInt(scanner.nextLine());
        char[][] first = new char[rows][colons];
        for (int i = 0; i <= first.length - 1; i++) {
            first[i] = scanner.nextLine().toCharArray();
        }
        char[][] second = new char[rows][colons];
        for (int i = 0; i <= second.length - 1; i++) {

            second[i] = scanner.nextLine().toCharArray();
        }
        for (int i = 0; i <= first.length - 1; i++) {
            for (int a = 0; a <= first[i].length - 1; a++) {
                if (first[i][a] == second[i][a]) {
                    System.out.print(first[i][a]);
                } else {
                    System.out.print('*');
                }
            }
            System.out.println();
        }

    }
}
