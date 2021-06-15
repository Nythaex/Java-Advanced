import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int rows=Integer.parseInt(scanner.nextLine());
        int [][]matrix=new int[rows][];
        for (int i = 0; i <= matrix.length - 1; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int i=0;
        int a=0;
        int Firstsum=0;
        int Secondtsum=0;
        while (i<=matrix.length-1&&a<=matrix[rows-1].length-1){
            Firstsum+=matrix[i][a];
            a++;
            i++;
        }
        System.out.println();
        i=matrix.length-1;
        a=0;
        while (i>=0&&a<=matrix[rows-1].length-1){
            Secondtsum+=matrix[i][a];
            a++;
            i--;
        }
        System.out.println(Firstsum>Secondtsum ?Firstsum-Secondtsum:Secondtsum-Firstsum);
    }
}
