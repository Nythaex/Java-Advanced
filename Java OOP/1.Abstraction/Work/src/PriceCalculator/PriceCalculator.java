package PriceCalculator;

public class PriceCalculator {
    public static String priceOfAll(double prce,int days,int season,int discount){
        return String.format("%.2f",(prce*days)*season-((prce*days)*season)*(discount*0.01));
    }
}
