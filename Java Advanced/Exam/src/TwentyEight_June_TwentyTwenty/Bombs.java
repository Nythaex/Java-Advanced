package TwentyEight_June_TwentyTwenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Bombs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> bombsMap = new HashMap<>();
        bombsMap.put("Datura Bombs", 0);
        bombsMap.put("Cherry Bombs", 0);
        bombsMap.put("Smoke Decoy Bombs", 0);
        ArrayDeque<Integer> bombEffect = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombEffect::offer);
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombCasing::push);
        while (!bombEffect.isEmpty() && !bombCasing.isEmpty()) {
            int effect = bombEffect.peek();
            int casing = bombCasing.peek();
            switch (effect + casing) {
                case 40:
                    bombsMap.put("Datura Bombs", bombsMap.get("Datura Bombs") + 1);
                    bombEffect.poll();
                    bombCasing.pop();
                    break;
                case 60:
                    bombsMap.put("Cherry Bombs", bombsMap.get("Cherry Bombs") + 1);
                    bombEffect.poll();
                    bombCasing.pop();
                    break;
                case 120:
                    bombsMap.put("Smoke Decoy Bombs", bombsMap.get("Smoke Decoy Bombs") + 1);
                    bombEffect.poll();
                    bombCasing.pop();
                    break;
                default:
                    bombCasing.pop();
                    bombCasing.push(casing - 5);
                    break;
            }
            if (bombsMap.get("Datura Bombs")>2&&bombsMap.get("Cherry Bombs")>2&&bombsMap.get("Smoke Decoy Bombs")>2){
                break;
            }
        }
        if (bombsMap.get("Datura Bombs")>2&bombsMap.get("Cherry Bombs")>2&&bombsMap.get("Smoke Decoy Bombs")>2){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffect.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.print("Bomb Effects: ");
            int size=bombEffect.size();
            for (int i = 0; i <size; i++) {
                System.out.print(bombEffect.poll());
                if (i!=size-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        if (bombCasing.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else {
            System.out.print("Bomb Casings: ");
            int size=bombCasing.size();
            for (int i = 0; i <size; i++) {
                System.out.print(bombCasing.pop());
                if (i!=size-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println("Cherry Bombs: "+bombsMap.get("Cherry Bombs"));
        System.out.println("Datura Bombs: "+bombsMap.get("Datura Bombs"));
        System.out.println("Smoke Decoy Bombs: "+bombsMap.get("Smoke Decoy Bombs"));
    }
}
