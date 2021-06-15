import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        Function<List<Integer>,List<String>> parse=p->p.stream().filter(n->n%2==0).map(s->String.valueOf(s)).collect(Collectors.toList());
        List <Integer>nums= Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        System.out.println(String.join(", ", parse.apply(nums)));
        Collections.sort(nums);
        System.out.println(String.join(", ", parse.apply(nums)));


    }
}
