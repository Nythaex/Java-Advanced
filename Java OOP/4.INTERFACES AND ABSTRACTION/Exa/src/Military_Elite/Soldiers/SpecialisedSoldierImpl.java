package Military_Elite.Soldiers;

import Military_Elite.Interfaces.ISpecialised;
import Military_Elite.enums.Corp;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements ISpecialised {
    protected Corp corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary,Corp corp) {
        super(id, firstName, lastName, salary);
        this.corp=corp;
    }

    @Override
    public Corp getCorp() {
        return corp;
    }

}
