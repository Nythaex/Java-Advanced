package Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
          BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
          String[] tokens=reader.readLine().split("\\s+");
          Tuple<String,String,String> tuple=new Tuple(tokens[0]+" "+tokens[1],tokens[2],tokens[3]);
        System.out.println(tuple.toString());

         tokens=reader.readLine().split("\\s+");
        Tuple <String,String,Boolean>tuplep=new Tuple(tokens[0],tokens[1],tokens[2].equals("drunk"));
        System.out.println(tuplep.toString());

         tokens=reader.readLine().split("\\s+");
        Tuple<String,Double,String> tuplee=new Tuple(tokens[0],Double.parseDouble(tokens[1]),tokens[2]);
        System.out.println(tuplee.toString());
    }
}
