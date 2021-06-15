import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Cooking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).forEach(liquids::offer);

        ArrayDeque<Integer> ingredient = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).forEach(ingredient::push);
        Map<String, Integer> food = new TreeMap<>();
        food.put("Bread", 0);
        food.put("Cake", 0);
        food.put("Pastry", 0);
        food.put("Fruit Pie", 0);
        while (!liquids.isEmpty() && !ingredient.isEmpty()) {
            int liq = liquids.poll();
            int ing = ingredient.peek();
            switch (liq + ing) {
                case 25:
                    food.put("Bread", food.get("Bread") + 1);
                    ingredient.pop();
                    break;
                case 50:
                    food.put("Cake", food.get("Cake") + 1);
                    ingredient.pop();
                    break;
                case 75:
                    food.put("Pastry", food.get("Pastry") + 1);
                    ingredient.pop();
                    break;
                case 100:
                    food.put("Fruit Pie", food.get("Fruit Pie") + 1);
                    ingredient.pop();
                    break;
                default:
                    int p = ingredient.pop();
                    ingredient.push(p + 3);
                    break;
            }
        }
        if (food.get("Bread") > 0 & food.get("Cake") > 0 && food.get("Pastry") > 0 && food.get("Fruit Pie") > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            int size = liquids.size();
            for (int i = 0; i < size; i++) {
                System.out.print(liquids.poll());
                if (i != size - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        if (ingredient.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            int size = ingredient.size();
            for (int i = 0; i < size; i++) {
                System.out.print(ingredient.pop());
                if (i != size - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println("Bread: " + food.get("Bread"));
        System.out.println("Cake: " + food.get("Cake"));
        System.out.println("Fruit Pie: " + food.get("Fruit Pie"));
        System.out.println("Pastry: " + food.get("Pastry"));
    }
}

