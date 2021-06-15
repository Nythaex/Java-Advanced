package CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String command=reader.readLine();
        Map<String,Siamese> cats=new HashMap<>();
        while(!command.equals("End")){
            String[] token=command.split("\\s+");
            Siamese siamese=new Siamese(token[0],token[1],Double.parseDouble(token[2]));
            cats.put(token[1],siamese);
            command=reader.readLine();
        }
        System.out.println(cats.get(reader.readLine()).toString());
    }
}
