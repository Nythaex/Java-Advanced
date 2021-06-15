package EqualityLogic;

import java.util.Iterator;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        if (this.name.compareTo(o.getName())!=0){
            return this.name.compareTo(o.getName());
        }else {
            return Integer.compare(this.age, o.getAge());
        }
    }
}
