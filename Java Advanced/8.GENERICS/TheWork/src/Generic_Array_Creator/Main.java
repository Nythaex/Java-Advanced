package Generic_Array_Creator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        Integer[] first=ArrayCreator.create(13,24);
       String[] second=ArrayCreator.create(String.class,13,"asf");
        for (String p:second
             ) {
            System.out.println(p.toString());
        }

    }
}
