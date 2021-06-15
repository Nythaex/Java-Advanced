package Pokemon_Trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
   private String name;
   private int numberOfBadges=0;
   private List <Pokemon>trainerPokemons;

   public Trainer(String name, List<Pokemon> trainerPokemons) {
      this.name = name;
      this.trainerPokemons = trainerPokemons;
   }

   public int getNumberOfBadges() {
      return numberOfBadges;
   }

   public List<Pokemon> getTrainerPokemons() {
      return trainerPokemons;
   }

   public void setNumberOfBadges() {
      this.numberOfBadges += 1;
   }
   public void purge(){
      trainerPokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
   }
}
