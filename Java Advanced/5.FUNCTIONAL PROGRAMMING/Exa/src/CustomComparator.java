import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums= Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Comparator<Integer> comparator=(s1,s2)->{
          if (s1%2==0&&s2%2!=0){
              return -1;
          }else if (s1%2!=0&&s2%2==0){
              return 1;
          }
          return Integer.compare(s1,s2);
        };
        nums.stream().sorted(comparator).forEach(s-> System.out.print(s+" "));

    }
}
