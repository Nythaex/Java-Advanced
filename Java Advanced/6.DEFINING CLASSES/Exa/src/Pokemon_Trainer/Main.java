package Pokemon_Trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String information = reader.readLine();
        while (!information.equals("Tournament")) {
            String[] tokens = information.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            Trainer trainer = new Trainer(trainerName, new ArrayList<>());
            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).getTrainerPokemons().add(pokemon);

            information = reader.readLine();
        }
        String elements=reader.readLine();
        while (!elements.equals("End")){
            for (Map.Entry<String, Trainer> trainer : trainers.entrySet()) {
                boolean havePokemonElement=false;
                for (Pokemon trainerPokemon : trainer.getValue().getTrainerPokemons()) {
                    if (trainerPokemon.getElement().equals(elements)){
                        havePokemonElement=true;
                        break;
                    }
                }
                if (havePokemonElement){
                    trainer.getValue().setNumberOfBadges();
                }else {
                    for (Pokemon trainerPokemon : trainer.getValue().getTrainerPokemons()) {
                        trainerPokemon.setHealth();
                    }
                    trainer.getValue().getTrainerPokemons().removeIf(pokemon -> pokemon.getHealth()<=0);
                }
            }
            elements=reader.readLine();
        }
        trainers.entrySet().stream().sorted((p1,p2)->Integer.compare(p2.getValue().getNumberOfBadges(), p1.getValue().getNumberOfBadges()))
                .forEach(s-> System.out.println(String.format("%s %d %d",s.getKey(),s.getValue().getNumberOfBadges(),s.getValue().getTrainerPokemons().size())));
    }

}
