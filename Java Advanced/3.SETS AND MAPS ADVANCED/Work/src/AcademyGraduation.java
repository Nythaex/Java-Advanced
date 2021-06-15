import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String, String> person=new TreeMap<>();

        int count=Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= count; i++) {
            String name=scanner.nextLine();
            double [] grade= Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            int length= grade.length;
            double sum=0;
            for (int a = 0; a <= length-1; a++) {
                sum+=grade[a];
            }
          person.putIfAbsent(name,String.valueOf(sum/length));
        }
        for (Map.Entry<String, String> stringDoubleEntry : person.entrySet()) {

            System.out.printf("%s is graduated with %s%n",stringDoubleEntry.getKey(),stringDoubleEntry.getValue());
        }

    }
}
