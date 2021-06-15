package Football_Team_Generator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Team> teams = new HashMap<>();
        String input;

        while (!"END".equals(input = scan.nextLine())) {

            String[] command = input.trim().split(";");
            String name = command[1];

            switch (command[0]) {
                case "Team":
                    Team team=new  Team(name);
                    if (!teams.containsKey(name)){
                        teams.put(name,team);
                    }else {

                    }
                    break;
                case "Add":
                    if (!teams.containsKey(name)){
                        System.out.printf("Team %s does not exist.%n",name);
                    }else{
                        Player player=new Player(command[2],
                                Integer.parseInt(command[3]),
                                Integer.parseInt(command[4]),
                                Integer.parseInt(command[5]),
                                Integer.parseInt(command[6]),
                                Integer.parseInt(command[7]));
                        teams.get(name).addPlayer(player);
                    }
                    break;
                case "Remove":
                    teams.get(name).removePlayer(command[2]);
                    break;
                case "Rating":
                    if (!teams.containsKey(name)){
                        System.out.printf("Team %s does not exist.%n",name);
                    }else {
                        System.out.printf("%s - %.0f%n",(teams.get(name).getRating()));
                    }
                    break;
            }
        }
    }
}
