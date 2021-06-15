package Inheritance;

public class Animal {
    protected String name;
    protected int age;
    private double salary;
    private String type;

   public Animal (String name,int age,String type){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected void eat(){
        System.out.println("eating...");
    }


    protected int getAge() {
        return age;
    }

}
