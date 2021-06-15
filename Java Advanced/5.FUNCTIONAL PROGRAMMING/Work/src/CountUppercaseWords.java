import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        Predicate<String> isItUpper=s -> Character.isUpperCase(s.charAt(0));

        List<String> text=  Arrays.stream(reader.readLine().split(" ")).filter(isItUpper).collect(Collectors.toList());
        System.out.println(text.size());
        for (String s:text
             ) {
            System.out.println(s);
        }





    }
}
