package RandomArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        RandomArrayList <Integer> list = new RandomArrayList();
        for (int i = 0; i<=33; i++) {
           list.add(i);
        }
        System.out.println(list.get(list.getRandomElement()));
    }
}
