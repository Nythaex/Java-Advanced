package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    private Random random=new Random();
    public  int getRandomElement(){
        return this.random.nextInt(super.size());
    }
}
