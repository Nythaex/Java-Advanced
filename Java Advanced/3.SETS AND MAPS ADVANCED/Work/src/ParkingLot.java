import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Set<String>set=new LinkedHashSet<>();
        String command=scanner.nextLine();
        while (!command.equals("END")){
            String[] tokens=command.split(", ");
            if (tokens[0].equals("IN")) {
                set.add(tokens[1]);
            }else {
                set.remove(tokens[1]);
            }
            command=scanner.nextLine();
        }
        if (set.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            set.forEach(s -> System.out.println(s));
        }
    }
}
