package rabbits;

import javax.management.relation.RoleList;
import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (getCapacity()> data.size()){
            data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return data.removeIf(l -> l.getName().equals(name));
    }

    public void removeSpecies(String species) {
       this.data.removeIf(l -> l.getSpecies().equals(species));
    }

    public int count() {
        return this.data.size();
    }

    public Rabbit sellRabbit(String name) {
        int index = -1;
        for (int i = 0; i <= this.data.size() - 1; i++) {
            if (this.data.get(i).getName().equals(name)){
                this.data.get(i).setAvailable(false);
                index=i;
            }
        }
        return data.get(index);
    }
    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> print=new ArrayList<>();
        for (int i = 0; i <= this.data.size() - 1; i++) {
            if (this.data.get(i).getSpecies().equals(species)){
                this.data.get(i).setAvailable(false);
                print.add(this.data.get(i));
            }
        }
        return print;
    }

    public String report() {
        StringBuilder print=new StringBuilder();
        print.append(String.format("Rabbits available at %s:",getName()));
        for (Rabbit rabbit:data
             ) {
            if (rabbit.isAvailable()){
                print.append(System.lineSeparator());
                print.append(rabbit.toString());
            }
        }

        return print.toString();
    }
}
