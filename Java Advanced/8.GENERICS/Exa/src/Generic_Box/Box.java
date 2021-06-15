package Generic_Box;

public class Box<T> {
    private T line;

    public Box(T line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",line.getClass().getName(),line.toString());
    }
}
