import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] first = new int[dim[0]][dim[1]];
        for (int i = 0; i <= first.length - 1; i++) {
            first[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int num=Integer.parseInt(scanner.nextLine());
        boolean found=false;
        for (int i = 0; i <= first.length - 1; i++) {
            for (int a = 0; a <= first[i].length - 1; a++) {
                if (first[i][a]==num){
                    System.out.println(i+" "+a);
                    found=true;
                }
            }
        }
        if (!found){
            System.out.println("not found");
        }
    }
}
