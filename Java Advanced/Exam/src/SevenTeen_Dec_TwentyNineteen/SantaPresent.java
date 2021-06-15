package SevenTeen_Dec_TwentyNineteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SantaPresent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> materials = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(materials::push);
        ArrayDeque<Integer> power = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(power::offer);
        Map<String, Integer> dolls = new TreeMap<>();
        dolls.put("Doll", 0);
        dolls.put("Wooden train", 0);
        dolls.put("Teddy bear", 0);
        dolls.put("Bicycle", 0);

        while (!materials.isEmpty() && !power.isEmpty()) {
            int theMaterial = materials.peek();
            int thePower = power.peek();

            if (theMaterial * thePower < 0) {
                materials.pop();
                power.poll();
                materials.push(theMaterial + thePower);
            } else if (theMaterial == 0 || thePower == 0) {
                if (theMaterial == 0) {
                    materials.pop();
                }
                if (thePower == 0) {
                    power.poll();
                }
            } else {
                switch (theMaterial * thePower) {
                    case 150:
                        dolls.put("Doll", dolls.get("Doll") + 1);
                        materials.pop();
                        power.poll();
                        break;
                    case 250:
                        dolls.put("Wooden train", dolls.get("Wooden train") + 1);
                        materials.pop();
                        power.poll();
                        break;
                    case 300:
                        dolls.put("Teddy bear", dolls.get("Teddy bear") + 1);
                        materials.pop();
                        power.poll();
                        break;
                    case 400:
                        dolls.put("Bicycle", dolls.get("Bicycle") + 1);
                        materials.pop();
                        power.poll();
                        break;
                    default:
                        theMaterial += 15;
                        materials.pop();
                        power.poll();
                        materials.push(theMaterial);
                        break;
                }
            }
        }
        if (dolls.get("Doll")>0&&dolls.get("Wooden train")>0){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else if (dolls.get("Teddy bear")>0&&dolls.get("Bicycle")>0){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else {
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()){
            System.out.print("Materials left: ");
            int size= materials.size()-1;
            for (int i = 0; i <= size; i++) {
                System.out.print(materials.pop());
                if (i!=size){
                    System.out.print(", ");
                }
            }
            System.out.println();
        } if (!power.isEmpty()) {
            System.out.println("Magic left: ");
            int size= power.size()-1;
            for (int i = 0; i <= size; i++) {
                System.out.print(power.poll());
                if (i !=size ) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        if (dolls.get("Bicycle")>0){
            System.out.println("Bicycle: "+dolls.get("Bicycle"));
        }
        if (dolls.get("Doll")>0){
            System.out.println("Doll: "+dolls.get("Doll"));
        }
        if (dolls.get("Teddy bear")>0){
            System.out.println("Teddy bear: "+dolls.get("Teddy bear"));
        }
        if (dolls.get("Wooden train")>0){
            System.out.println("Wooden train: "+dolls.get("Wooden train"));
        }
    }
}
