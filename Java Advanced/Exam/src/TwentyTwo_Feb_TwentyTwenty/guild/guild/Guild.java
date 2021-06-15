package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.removeIf(s -> s.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player player : roster
        ) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster
        ) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
                break;
            }
        }
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[]p= this.roster.stream().filter(player -> player.getClazz().equals(clazz)).toArray(Player[]::new);
        setRoster(this.roster.stream().filter(player -> !player.getClazz().equals(clazz)).collect(Collectors.toList()));
        return p;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder(String.format("Players in the guild: %s:", this.name));
        for (Player p : roster
        ) {
            builder.append(System.lineSeparator());
            builder.append(p.toString());
        }
        builder.append(System.lineSeparator());
        return builder.toString();

    }

}
