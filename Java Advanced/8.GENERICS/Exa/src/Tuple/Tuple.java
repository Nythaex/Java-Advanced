package Tuple;

public class Tuple<T,V,R> {
    private T first;
    private V second;
    private R third;

    public Tuple(T first, V second,R third) {
        this.first=first;
        this.second=second;
        this.third=third;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s",this.first,this.second,this.third);
    }
}
