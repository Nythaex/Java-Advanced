package PriceCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] tokens = reader.readLine().split("\\s+");
        String nameOfDiscount = tokens[3].equals("SecondVisit")?"SECOND_VISIT":tokens[3].toUpperCase(Locale.ROOT);
        System.out.println(PriceCalculator.priceOfAll(Double.parseDouble(tokens[0]),Integer.parseInt(tokens[1]),
                Seasons.valueOf(tokens[2].toUpperCase(Locale.ROOT)).getSeasonMultiplier(),Discount.valueOf(nameOfDiscount).getDiscount()));
    }
}
