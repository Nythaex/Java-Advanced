package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static class comperator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1,o2);
        }
    }

    public static void main(String[] args) throws IOException {BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<Integer>();
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            String[] token = reader.readLine().split("\\s+");
            switch (token[0]) {
                case "Add":
                   list.Add(Integer.parseInt(token[1]));
                    break;
                case "Remove":
                    list.Remove(Integer.parseInt(token[1]));
                    break;
            }
        }


        System.out.println(list.count());
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
}
