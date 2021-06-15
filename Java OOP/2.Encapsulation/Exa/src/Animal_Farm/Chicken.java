package Animal_Farm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name.length()>1) {
            this.name = name;
        }else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    private void setAge(int age) {
        if (age>=0&&age<=15) {
            this.age=age;
        }else {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }
    public double productPerDay() {
        return calculateProductPerDay();
    }
    private double calculateProductPerDay(){
        if (this.age<6){
            return 2;
        }else if (this.age<12) {
            return 1;
        }
        return 0.75;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
