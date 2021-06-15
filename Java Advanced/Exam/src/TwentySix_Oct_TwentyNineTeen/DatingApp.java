package TwentySix_Oct_TwentyNineTeen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatingApp {
    public static void main(String[] args) throws IOException {
        int matchesCount = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).forEach(males::push);

        ArrayDeque<Integer> females = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).forEach(females::offer);

        while (!males.isEmpty() && !females.isEmpty()) {
            int male = males.peek();
            int female = females.peek();
            if (male <= 0) {
                males.pop();
            } else if (female <= 0) {
                females.poll();
            } else if (male % 25 == 0) {
                males.pop();
                if (!males.isEmpty()){
                    males.pop();
                }
            } else if (female % 25 == 0) {
                females.poll();
                if (!females.isEmpty()){
                    females.poll();
                }
            } else if (male == female) {
                matchesCount++;
                males.pop();
                females.poll();
            } else {
                females.poll();
                male = males.pop();
                males.push(male - 2);
            }
        }
        System.out.println("Matches: " + matchesCount);
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            List<String> p = new ArrayList<>();
            int size=males.size();
            for (int i = 0; i < size; i++) {
                p.add(String.valueOf(males.pop()));
            }
            System.out.println("Males left: " + String.join(", ", p.stream().toArray(String[]::new)));
        }
        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            List<String> p = new ArrayList<>();
            int size= females.size();
            for (int i = 0; i < size; i++) {
                p.add(String.valueOf(females.poll()));
            }
            System.out.println("Females left: " + String.join(", ", p.stream().toArray(String[]::new)));
        }


    }
}
