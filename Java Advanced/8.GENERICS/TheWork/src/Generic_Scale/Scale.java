package Generic_Scale;

public class Scale<T extends Comparable> {
    private T first;
    private T second;

    public Scale(T first,T second){
        this.first=first;
        this.second=second;
    }

    public T getHeavier(){
        if (this.first==this.second){
            return null;
        }
        if (this.first.compareTo(this.second)>=1){
            return first;
        }
        return second;
    }

}
