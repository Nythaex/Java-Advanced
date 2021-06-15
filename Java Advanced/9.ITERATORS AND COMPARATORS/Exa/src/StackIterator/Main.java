package StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        Stack stack = new Stack();
        while (!command.equals("END")) {
            String[] tokens = command.split("\\b\\s+");
            switch (tokens[0]) {
                case "Push":
                    stack.Push(tokens[1]);
                    break;
                case "Pop":
                    stack.Pop();
                    break;
            }
            command = reader.readLine();
        }

        for (Integer integer : stack) {
            System.out.println(integer);
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }

    }
}
