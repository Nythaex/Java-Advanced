import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Set<String> guests=new TreeSet<>();
        String command=scanner.nextLine();
        while (!command.equals("PARTY")){
            guests.add(command);
            command=scanner.nextLine();
        }
        command=scanner.nextLine();
        while (!command.equals("END")){
            guests.remove(command);
            command=scanner.nextLine();
        }
        System.out.println(guests.size());
        Arrays.stream(guests.toArray()).forEach(System.out::println);
    }
}
