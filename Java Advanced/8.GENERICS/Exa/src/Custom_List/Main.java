package Custom_List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        CustomList<String> list = new CustomList<String>();
        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Add":
                    list.Add(tokens[1]);
                    break;
                case "Remove":
                    list.Remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(list.Contains(tokens[1]));
                    break;
                case "Swap":
                    list.Swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(list.Greater(tokens[1]));
                    break;
                case "Max":
                    System.out.println(list.Max());
                    break;
                case "Min":
                    System.out.println(list.Min());
                    break;
                case "Print":

                    Iterator<String> it = list.iterator();

                    while (it.hasNext()) {
                        System.out.println(it.next());

                    }

                    break;
                case "Sort":
                    list.Sort();
                    break;

            }

            command = reader.readLine();
        }
    }
}
