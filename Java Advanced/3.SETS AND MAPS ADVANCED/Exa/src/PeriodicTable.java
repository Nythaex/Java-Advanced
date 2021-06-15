import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Set<String> names = new TreeSet<>();
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String[] tokens=scanner.nextLine().split("\\s+");
            names.addAll(Arrays.asList(tokens));
        }
        for (String p:names
        ) {
            System.out.print(p+" ");
        }
    }
}
