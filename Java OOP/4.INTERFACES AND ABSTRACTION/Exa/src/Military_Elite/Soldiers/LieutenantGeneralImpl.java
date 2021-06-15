package Military_Elite.Soldiers;

import Military_Elite.Comperators.LieutenantComparator;
import Military_Elite.Interfaces.ILieutenant;

import java.util.*;

public class LieutenantGeneralImpl extends PrivateImpl implements ILieutenant {
    private Set<PrivateImpl> privateSet;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary,List <PrivateImpl>args) {
        super(id, firstName, lastName, salary);
        privateSet=new HashSet<>();
        privateSet.addAll(args);
    }

    @Override
    public void addPrivate(PrivateImpl soldier) {
         privateSet.add(soldier);
    }

    @Override
    public Set<PrivateImpl> getSet() {
        return this.privateSet;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s %s Id: %d Salary: %.2f",this.firstName,this.lastName,this.id,this.salary));
        builder.append(System.lineSeparator());
        builder.append(String.format("Privates:"));

        for (PrivateImpl p:privateSet
             ) {
            builder.append(System.lineSeparator());
            builder.append(p.toString());
        }

        return builder.toString();
    }
}
