package ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        ListyIterator listyIterator =null;
        while (!"END".equals(command)) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    listyIterator=new ListyIterator(Arrays.asList(tokens.clone()));
                    break;
                case "Move":
                    System.out.println(listyIterator.Move());
                    break;
                case "Print":
                    listyIterator.Print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.HasNext());
                    break;
                case "PrintAll":
                    for (String s : listyIterator) {
                        System.out.print(s+" ");
                    }
                    System.out.println();
                    break;
            }
            command = reader.readLine();
        }
    }
}
