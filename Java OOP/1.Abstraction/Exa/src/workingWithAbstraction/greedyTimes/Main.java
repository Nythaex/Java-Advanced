
package workingWithAbstraction.greedyTimes;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        Bag bag = new Bag(bagCapacity);
        String[] item = scanner.nextLine().split("\\s+");


        for (int i = 0; i < item.length; i += 2) {
            String name = item[i];
            long itemValue = Long.parseLong(item[i + 1]);
            bag.add(name, itemValue);
        }
        System.out.println(printInventory(bag));
    }


    private static String printInventory(Bag bag) {
        StringBuilder builder = new StringBuilder();
        if (bag.getGold() != null) {
            printGold(bag, builder);
        }
        if (bag.getGems().size()!= 0) {
            printGems(bag, builder);
        }
        if (bag.getCash().size() != 0) {
            printCash(bag, builder);
        }

        return builder.toString();
    }

    private static void printCash(Bag bag, StringBuilder builder) {
        builder.append("<Cash> $" + bag.getCash().values().stream().mapToLong(l -> l).sum());
        builder.append(System.lineSeparator());
        bag.getCash().entrySet().stream().sorted((s1, s2) -> {
            if (s1.getKey().equals(s2.getKey())) {
                Long.compare(s1.getValue(), s2.getValue());
            }
            return s2.getKey().compareTo(s1.getKey());
        }).forEach(s -> builder.append(String.format("##%s - %d%n", s.getKey(), s.getValue())));
    }

    private static void printGems(Bag bag, StringBuilder builder) {
        builder.append("<Gem> $" + bag.getGems().values().stream().mapToLong(l -> l).sum());
        builder.append(System.lineSeparator());
        bag.getGems().entrySet().stream().sorted((s1, s2) -> {
            if (s1.getKey().equals(s2.getKey())) {
                Long.compare(s1.getValue(), s2.getValue());
            }
            return s2.getKey().compareTo(s1.getKey());
        }).forEach(s -> builder.append(String.format("##%s - %d%n", s.getKey(), s.getValue())));
    }

    private static void printGold(Bag bag, StringBuilder builder) {
        builder.append("<Gold> $" + bag.getGold());
        builder.append(System.lineSeparator());
        builder.append("##Gold - " + bag.getGold());
        builder.append(System.lineSeparator());
    }
}