package Inheritance;

public class Dog extends Animal {

    public Dog(String name, int age, String type) {
        super(name, age, type);
    }

    public Dog(String name, int age) {
        super(name, age);
    }


    public void bark(){
        System.out.println("barking...");
    }
}
