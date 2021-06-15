package Military_Elite.Soldiers;

import Military_Elite.Interfaces.ICommando;
import Military_Elite.Resources.Mission;
import Military_Elite.Resources.Repair;
import Military_Elite.enums.Corp;

import java.util.*;

public class CommandoImpl extends SpecialisedSoldierImpl implements ICommando {
    private Set<Mission> missionsSet;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corp corp, List<Mission> args) {
        super(id, firstName, lastName, salary, corp);
        missionsSet=new LinkedHashSet<>();
        missionsSet.addAll(args);
    }

    @Override
    public void addReMission(Mission mission) {
        missionsSet.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return getMissions();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s %s Id: %d Salary: %.2f",this.firstName,this.lastName,this.id,this.salary));
        builder.append(System.lineSeparator());
        builder.append(String.format("Corps: %s",this.corp.getNormalCase()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Missions:"));

        for (Mission mission:missionsSet
        ) {
            builder.append(System.lineSeparator());
            builder.append(mission.toString());
        }

        return builder.toString();
    }
}
