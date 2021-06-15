package TwentyThree_Oct_TwentyNine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class MakeASalad {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> vegetables = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).map(String::toString).forEach(vegetables::offer);

        ArrayDeque<Integer> saladCal = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).forEach(saladCal::push);

        List<Integer> doneSalads = new ArrayList<>();
        List<Integer> undoneSalads = new ArrayList<>();
        List<String> vege = new ArrayList<>();

        while (!vegetables.isEmpty() && !saladCal.isEmpty()) {
            int currentSalad = saladCal.pop();
            int cals = 0;
            while (!vegetables.isEmpty() && cals < currentSalad) {
                String currentVegetable = vegetables.poll();
                switch (currentVegetable) {
                    case "tomato":
                        cals += 80;
                        break;
                    case "potato":
                        cals += 215;
                        break;
                    case "carrot":
                        cals += 136;
                        break;
                    case "lettuce":
                        cals += 109;
                        break;
                }
            }
            if (currentSalad > cals) {
                saladCal.push(currentSalad - cals);
            } else {
                doneSalads.add(currentSalad);

            }
        }
        int size = saladCal.size();
        for (int i = 0; i < size; i++) {
            undoneSalads.add(saladCal.pop());
        }
        size = vegetables.size();
        for (int i = 0; i < size; i++) {
            vege.add(vegetables.poll());
        }
        System.out.println(doneSalads.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
        if (vege.isEmpty()) {
            System.out.println(undoneSalads.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));
        } else {
            System.out.println(String.join(" ",vege));
        }


    }
}
