import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers= Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int n=Integer.parseInt(reader.readLine());
        Collections.reverse(numbers);
        Predicate<Integer> filter=s->s%n!=0;
        Function<List<Integer>,List<Integer>> filt=integers -> integers.stream().filter(s->filter.test(s)).collect(Collectors.toList());
        numbers=filt.apply(numbers);
        numbers.stream().forEach(s-> System.out.print(s+" "));
    }
}
