package Inheritance;

public class Puppy extends Dog {
    public Puppy(String name, int age, String type) {
        super(name, age, type);
    }

    public void weep(){
            System.out.println("weeping...");
        }
}
