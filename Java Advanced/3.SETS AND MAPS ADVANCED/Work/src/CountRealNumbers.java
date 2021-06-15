import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<Double,Integer> values=new LinkedHashMap<>();
        double [] nums= Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        for (int i = 0; i <= nums.length - 1; i++) {
            if (values.containsKey(nums[i])){
                int count=values.get(nums[i]);
                values.put(nums[i],values.get(nums[i])+1);
            }else {
                values.put(nums[i], 1);
            }
        }
        for (Map.Entry<Double, Integer> doubleIntegerEntry : values.entrySet()) {
            System.out.println(String.format("%.1f -> %d",doubleIntegerEntry.getKey(),doubleIntegerEntry.getValue()));
        }

    }
}
