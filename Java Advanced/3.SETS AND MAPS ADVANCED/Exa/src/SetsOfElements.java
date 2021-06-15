import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Set<String> first = new LinkedHashSet<>();
        Set<String> second = new LinkedHashSet<>();
        int[] num = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < num[0]; i++) {
            first.add(scanner.nextLine());
        }
        for (int i = 0; i < num[1]; i++) {
            second.add(scanner.nextLine());
        }
        for (String p:first
        ) {
            if (second.contains(p)){
                System.out.print(p+" ");
            }
        }
    }
}
