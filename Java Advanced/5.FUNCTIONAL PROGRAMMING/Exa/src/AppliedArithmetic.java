import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        Function<int[],int[]> add=ints -> Arrays.stream(ints).map(s->s+1).toArray();
        Function<int[],int[]> sub=ints -> Arrays.stream(ints).map(s->s-1).toArray();
        Function<int[],int[]> multi=ints -> Arrays.stream(ints).map(s->s*2).toArray();
        Consumer<int[]> print=ints -> Arrays.stream(ints).forEach(s-> System.out.print(s+" "));
        int [] nums=Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command=reader.readLine();
        while (!command.equals("end")){
            switch (command){
                case "add":
                    nums=add.apply(nums);
                    break;
                case "multiply":
                    nums=multi.apply(nums);
                    break;
                case "print":
                    print.accept(nums);
                    System.out.println();
                    break;
                case "subtract":
                    nums=sub.apply(nums);
                    break;
            }
            command=reader.readLine();

        }
    }
}
