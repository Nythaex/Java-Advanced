package Valid_Person;

public class Person {
    private String firstName;
    private String secondName;
    private int age;

    public Person(String firstName, String secondName, int age) throws InvalidPersonNameException {
        setFirstName(firstName);
        setSecondName(secondName);
        setAge(age);

    }


    private void setFirstName(String firstName) throws InvalidPersonNameException {
        checkNameValuebility(firstName,"first");
        this.firstName = firstName;
    }

    private void checkNameValuebility(String name,String type) throws InvalidPersonNameException {
        if (name==null||name.trim().length()==0){
            throw new InvalidPersonNameException("The "+type+" name cannot be null or empty");
        }
    }
    private void checkAge(int age) throws IllegalArgumentException {
        if (age<0||age>120){
            throw new IllegalArgumentException("Age should be in the range [0 ... 120]");
        }
    }

    private void setSecondName(String secondName) throws InvalidPersonNameException {
        checkNameValuebility(secondName,"second");
        this.secondName = secondName;
    }

    private void setAge(int age) {
        checkAge(age);
        this.age = age;
    }
}
