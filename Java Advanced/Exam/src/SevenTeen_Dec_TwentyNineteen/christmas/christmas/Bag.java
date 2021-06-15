package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;

    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (this.data.size() < getCapacity()) {
            this.data.add(present);
        }
    }public boolean remove(String name) {
        return this.data.removeIf(s->s.getName().equals(name));
    }
    public Present heaviestPresent(){
        return this.data.stream().sorted((s1,s2)->Double.compare(s2.getWeight(),s1.getWeight())).findAny().orElse(null);
    }public Present getPresent(String name){
        return this.data.stream().filter(s->s.getName().equals(name)).findAny().orElse(null);
    }


    public String report() {
        StringBuilder print=new StringBuilder();
        print.append(getColor()+"bag contains:");
        for (int i = 0; i <=data.size() - 1; i++) {
            print.append(System.lineSeparator());
            print.append(data.get(i).toString());
        }

        return print.toString();
    }
}
