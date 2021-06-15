package TwentyTwo_Feb_TwentyTwenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class LootBox {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> firstBox=new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(firstBox::offer);
        ArrayDeque<Integer> secondBox=new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(secondBox::push);
        int sum=0;

        while (!firstBox.isEmpty()&&!secondBox.isEmpty()){
            int first=firstBox.peek();
            int second=secondBox.peek();
            if ((first+second)%2==0){
                sum+=first+second;
                firstBox.poll();
                secondBox.pop();
            }else {
                firstBox.offer(secondBox.pop());
            }
        }
        if (firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }else {
            System.out.println("Second lootbox is empty");
        }
        if (sum>=100){
            System.out.println("Your loot was epic! Value: "+sum);
        }else {
            System.out.println("Your loot was poor... Value: "+sum);
        }


    }
}
