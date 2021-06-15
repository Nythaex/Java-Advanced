package Google_2;

import java.util.ArrayList;
import java.util.List;

public class Pokemons {
    private List<String> pokemons;

    public Pokemons() {
        pokemons = new ArrayList<>();
    }

    public List<String> getPokemons() {
        return this.pokemons;
    }

    public void addPok(String s){
        pokemons.add(s);
    }

}
