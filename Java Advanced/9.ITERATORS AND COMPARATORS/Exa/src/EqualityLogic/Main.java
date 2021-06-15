package EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main  {
    static class Comparator implements java.util.Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            if (o1.getName().compareTo(o2.getName())!=0){
                return o1.getName().compareTo(o2.getName());
            }else {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> tree = new TreeSet<>(new Comparator());
        Set<Person> hash = new HashSet<>();

        int d=Integer.parseInt(reader.readLine());
        for (int i = 0; i <d; i++) {
            String[] token = reader.readLine().split("\\s+");
            Person person=new Person(token[0],Integer.parseInt(token[1]));
            tree.add(person);
            boolean da=true;
            for (Person p:hash
                 ) {
                if (p.compareTo(person) == 0) {
                    da = false;
                    break;
                }
            }
            if (da){
                hash.add(person);
            }
        }
        System.out.println(tree.size());
        System.out.println(hash.size());


    }
}
