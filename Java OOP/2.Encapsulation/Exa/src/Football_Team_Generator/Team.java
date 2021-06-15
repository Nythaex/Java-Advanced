package Football_Team_Generator;


import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().equals("")) {
            System.out.println("A name should not be empty.");
        } else {
            this.name = name;
        }

    }

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        if (!player.incorrect){
            players.add(player);
        }
    }

    public void removePlayer(String name) {
        boolean contains = players.removeIf(s -> s.getName().equals(name));
        if (!contains) {
            System.out.printf("Player %s is not in %s team.%n", name, getName());
        }
    }

    public double getRating() {
        return players.stream().mapToDouble(s -> s.overallSkillLevel()).sum();
    }

    //-	name: String
    //-	players: List<Player>
    //+ 	Team (String)
    //-	setName(String) : void
    //+	getName(): String
    //+	addPlayer(Player) : void
    //+	removePlayer(String) : void
    //+	getRating() : double
}
