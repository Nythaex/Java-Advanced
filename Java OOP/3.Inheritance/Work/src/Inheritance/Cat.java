package Inheritance;

public class Cat extends Animal {


    public Cat(String name, int age, String type) {
        super(name, age, type);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    public void meow() {
        System.out.println("meowing...");
    }
}
