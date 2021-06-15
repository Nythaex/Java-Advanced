package Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int index = 0;
        int[] rocks = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        Lake lake = new Lake(rocks);
        reader.readLine();
        for (Integer integer : lake) {
            builder.append(integer);
            if (index < rocks.length - 1) {
                builder.append(", ");
            }
            index++;
        }
        lake.setFinishedEvens(true);
        for (Integer integer : lake) {
            builder.append(integer);
            if (index < rocks.length - 1) {
                builder.append(", ");
            }
            index++;
        }
        System.out.println(builder.toString());
    }
}
