package CardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name=reader.readLine();
        String type=reader.readLine();

        Cards card = new Cards(CardsRank.valueOf(name).getPower()+CardSuits.valueOf(type).getPower(),name,type);
        System.out.println(card.toString());
    }
}
