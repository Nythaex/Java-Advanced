import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int lenght=Integer.parseInt(reader.readLine());
        Predicate<String> check=strings -> strings.length()<=lenght;
        Arrays.stream(reader.readLine().split(" ")).filter(se -> check.test(se)).forEach(s-> System.out.println(s));
    }
}
