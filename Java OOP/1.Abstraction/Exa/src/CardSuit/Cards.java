package CardSuit;

public class Cards {
    int power;
    String name;
    String type;

    public Cards(int power, String name,String type) {
        this.power = power;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",name,type,power);
    }
}
