package Generic_CountMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(reader.readLine());
        List<Double> list=new ArrayList<>();
        for (int i = 0; i <count; i++) {
         list.add(Double.parseDouble(reader.readLine()));
        }
        System.out.println(Box.count(list,Double.parseDouble(reader.readLine())));
    }
}
