package viceCity.models.players;

public class MainPlayer extends BasePlayer{
    private static  int LIFE_POINTS=100;
    private static  String NAME="Tommy Vercetti";

    public MainPlayer() {
        super(NAME, LIFE_POINTS);
    }
}
