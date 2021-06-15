import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(reader.readLine());
        Map<String,Integer> people=new LinkedHashMap<>();
        for (int i = 0; i <count; i++) {
            String []tokens=reader.readLine().split(", ");
            people.putIfAbsent(tokens[0],Integer.parseInt(tokens[1]));
        }
        String olderOrYounger=reader.readLine();
        int age=Integer.parseInt(reader.readLine());
        String typePrinting=reader.readLine();
        removeFalse(olderOrYounger,age,people);
        switch (typePrinting){
            case "name":
                printName(people,typePrinting);
                break;
            case "age":
                printAge(people,typePrinting);
                break;
            case "name age":
                printBoth(people,typePrinting);
                break;

        }

    }

    private static void printBoth(Map<String, Integer> people, String typePrinting) {
        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }
    }

    private static void printAge(Map<String, Integer> people, String typePrinting) {
        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static void printName(Map<String, Integer> people,String type) {
        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            System.out.println(entry.getKey());
        }

    }

    private static void removeFalse(String olderOrYounger, int age, Map<String, Integer> people) {
            switch (olderOrYounger){
                case "younger":
                    people.entrySet().removeIf(s->s.getValue()>age);
                    break;
                case "older":
                    people.entrySet().removeIf(s->s.getValue()<age);
                    break;
            }


    }
}
