package hero;

public class Hero {
    public String username;
    public int level;

    public String getUsername() {
        return username;
    }

    protected int getLevel() {
        return level;
    }

    protected Hero(String username, int level) {
        this.username = username;
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(),
                this.getUsername(),
                this.getLevel());
    }

}
