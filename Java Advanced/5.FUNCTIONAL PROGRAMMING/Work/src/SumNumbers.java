import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String[] nums=reader.readLine().split(", ");
        Function<String,Integer> suma=s->Integer.parseInt(s);
        int sum=0;
        for (String s:nums
             ) {
            sum+=suma.apply(s);
        }
        System.out.printf("Count = %d%n",nums.length);
        System.out.printf("Sum = %d%n",sum);



    }
}
