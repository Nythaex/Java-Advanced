import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class FlowerWreaths {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> lilies=new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).forEach(lilies::push);
        ArrayDeque<Integer> rosses=new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).forEach(rosses::offer);
        int wreaths=0;
        int flowers=0;

        while (!rosses.isEmpty()&&!lilies.isEmpty()){
            int rose=rosses.poll();
            int lili=lilies.pop();
            if (rose+lili==15){
                wreaths+=1;
            }else if (rose+lili<15){
                flowers+=rose+lili;
            }else {
                while (rose+lili>15&&lili>=0){
                    lili-=2;
                    if (rose+lili==15){
                        wreaths++;
                        break;
                    }else if (rose+lili<15){
                        flowers+=rose+lili;
                        break;
                    }
                }
            }
        }
        while (flowers>=15){
            wreaths++;
            flowers-=15;
        }
        if (wreaths>=5){
            System.out.println(String.format("You made it, you are going to the competition with %d wreaths!",wreaths));
        }else {
            System.out.println(String.format("You didn't make it, you need %d wreaths more!",5-wreaths));
        }

    }
}
