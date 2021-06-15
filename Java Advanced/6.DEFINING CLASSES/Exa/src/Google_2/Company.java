package Google_2;

public class Company {
   private String company;
   private double salary;

    public Company(String company,double salary) {
        this.company = company;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return company+String.format(" %.2f",salary);
    }
}
