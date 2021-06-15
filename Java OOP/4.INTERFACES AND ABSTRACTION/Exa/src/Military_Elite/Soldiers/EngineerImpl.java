package Military_Elite.Soldiers;

import Military_Elite.Interfaces.IEngineer;
import Military_Elite.Resources.Repair;
import Military_Elite.enums.Corp;

import java.util.*;

public class EngineerImpl extends SpecialisedSoldierImpl implements IEngineer {
    private Set<Repair> repairSet;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corp corp,List<Repair> args) {
        super(id, firstName, lastName, salary, corp);
        repairSet=new LinkedHashSet<>();
        repairSet.addAll(args);
    }


    @Override
    public void addRepair(Repair repair) {
        repairSet.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return getRepairs();
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s %s Id: %d Salary: %.2f",this.firstName,this.lastName,this.id,this.salary));
        builder.append(System.lineSeparator());
        builder.append(String.format("Corps: %s",this.corp.getNormalCase()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Repairs:"));

        for (Repair repair:repairSet
        ) {
            builder.append(System.lineSeparator());
            builder.append(repair.toString());
        }

        return builder.toString();
    }
}
