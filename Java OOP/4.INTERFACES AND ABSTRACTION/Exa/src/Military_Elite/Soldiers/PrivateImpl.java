package Military_Elite.Soldiers;

import Military_Elite.Interfaces.IPrivate;

public class PrivateImpl extends SoldierImpl implements IPrivate {
    protected double salary;

    public PrivateImpl(int id, String firstName, String lastName,double salary) {
        super(id,firstName,lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d Salary: %.2f",this.firstName,this.lastName,this.id,this.salary);
    }
}
