import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        UnaryOperator<Double> VAT= s -> s*=1.2;
        List<Double> text=  Arrays.stream(reader.readLine().split(", ")).mapToDouble(Double::parseDouble).boxed().collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        for (Double s:text
        ) {
            System.out.println(String.format("%.2f",VAT.apply(s)));
        }
    }
}
