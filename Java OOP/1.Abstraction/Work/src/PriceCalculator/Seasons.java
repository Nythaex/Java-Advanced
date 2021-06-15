package PriceCalculator;

public enum Seasons {
    AUTUMN(1,"Atumn"),
    SPRING(2,"Spring"),
    WINTER(3,"Winter"),
    SUMMER(4,"Summer");
    int seasonMultiplier;
    String name;
    Seasons( int seasonMultiplier,String name) {
        this.seasonMultiplier=seasonMultiplier;
        this.name=name;
    }

    public int getSeasonMultiplier() {
        return seasonMultiplier;
    }
}
