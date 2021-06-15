package Stratagy_Pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static class compareName implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            if (o1.getName().length()-o2.getName().length()!=0){
                return o1.getName().length()-o2.getName().length();
            }
            if (Character.isLowerCase(o2.getName().charAt(0))){
                return 1;
            }else if (Character.isLowerCase(o1.getName().charAt(0)))
            {
                return -1;
            }
            return o1.getName().charAt(0)-o2.getName().charAt(0);
        }
    }
    public static class compareAge implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge()-o2.getAge();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(reader.readLine());
        TreeSet<Person> first=new TreeSet<>(new compareName());
        TreeSet<Person> second=new TreeSet<>(new compareAge());
        for (int i = 0; i <=count-1; i++) {
            String []tokens=(reader.readLine().split("\\s+"));
            Person person=new Person(tokens[0],Integer.parseInt(tokens[1]));
            first.add(person);
            second.add(person);
        }
        for (Person person : first) {
            System.out.println(person.getName()+" "+person.getAge());
        }
        for (Person person :second) {
            System.out.println(person.getName()+" "+person.getAge());
        }

    }
}
