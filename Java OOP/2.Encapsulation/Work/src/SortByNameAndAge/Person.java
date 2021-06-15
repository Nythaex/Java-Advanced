package SortByNameAndAge;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private double increaseSalary;

    public Person(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.lastName = secondName;
        this.age = age;
    }

    public Person(String firstName, String lastName, int age, double salary, double increaseSalary) {
        this(firstName,lastName,age);
        this.salary = salary;
        this.increaseSalary = increaseSalary;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.",getFirstName(), getLastName(),getAge());
    }

}
