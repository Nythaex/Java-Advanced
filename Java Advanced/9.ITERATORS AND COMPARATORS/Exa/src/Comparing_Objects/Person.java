package Comparing_Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person o) {
        if (this.town.compareTo(o.town)==0){
            if (this.name.compareTo(o.name)==0){
                return Integer.compare(this.age,o.age);
            }
            return this.name.compareTo(o.name);
        }
        return this.town.compareTo(o.town);
    }
}
