package FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        this.firstTeam=new ArrayList<Person>();
        this.reserveTeam=new ArrayList<Person>();
    }

    public String getName() {
        return name;
    }
    public void addPlayer(Person person){
        if (person.getAge()<40){
            firstTeam.add(person);
        }else {
           reserveTeam.add(person);
        }
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }
    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("First team have %d players",getFirstTeam().size()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Reserve team have %d players",getReserveTeam().size()));
        return builder.toString();
    }
}
