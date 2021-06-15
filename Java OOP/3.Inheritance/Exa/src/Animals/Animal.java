package Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name==null||name.trim().equals("")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    private void setGender(String gender) {
        if (gender==null||gender.trim().equals("")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }
    public String produceSound(){
        return "";
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(this.getClass().getSimpleName());
        print.append(System.lineSeparator());
        print.append(getName() + " " + getAge() + " " + getGender());
        print.append(System.lineSeparator());
        print.append(produceSound());

        return print.toString();
    }
}
