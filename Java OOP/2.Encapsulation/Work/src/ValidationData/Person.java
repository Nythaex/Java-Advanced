package ValidationData;

public class Person  {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;


    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);

    }

    public void increaseSalary(double salary) {
        if (getAge()<30){
            setSalary(this.salary+(0.01*salary*this.salary)/2);
        }else{
            setSalary(this.salary+(0.01*salary*this.salary));
        }
    }

    public double getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length()<=3){
            throw new IllegalArgumentException("Massage");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length()<=3){
            throw new IllegalArgumentException("Massage");
        }
        this.lastName = lastName;
    }

   public void setAge(int age) {
        if (age<1){
            throw new IllegalArgumentException("Massage");
        }

        this.age = age;
    }

    public void setSalary(double salary) {
        if (salary<460){
            throw new IllegalArgumentException("Massage");
        }
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva",getFirstName(), getLastName(),getSalary());
    }

}
