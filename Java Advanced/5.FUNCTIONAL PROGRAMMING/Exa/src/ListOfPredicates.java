import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int number=Integer.parseInt(reader.readLine());
        Set<Integer> numbers= Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toCollection(HashSet::new));
        BiPredicate<Integer,Set<Integer>> check=(num,set)->{
            for (int n:set
                 ) {
                if (num%n!=0){
                    return false;
                }
            }
            return true;
        };
        for (int i = 1; i <=number; i++) {
            if (check.test(i,numbers)){
                System.out.print(i+" ");
            }
        }


    }
}
