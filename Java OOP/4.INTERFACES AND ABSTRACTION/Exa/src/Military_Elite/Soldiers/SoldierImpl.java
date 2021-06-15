package Military_Elite.Soldiers;

import Military_Elite.Interfaces.ISoldier;

public abstract class SoldierImpl implements ISoldier {
    protected int id;
    protected String firstName;
    protected String lastName;

    protected SoldierImpl(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public abstract String toString();
}
