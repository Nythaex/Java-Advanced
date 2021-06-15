package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }
    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }
    public boolean remove(String name) {
        return data.removeIf(s -> s.getName().equals(name));
    }
    public int getCount() {
        return data.size();
    }
    public Pet getPet(String name, String owner) {
        return this.data.stream().filter(s -> s.getName().equals(name) && s.getOwner().equals(owner)).findFirst().orElse(null);
    }
    public Pet getOldestPet() {
        return this.data.stream().sorted((s1, s2) -> Integer.compare(s2.getAge(), s1.getAge())).findFirst().orElse(null);
    }
    public String getStatistics() {
        StringBuilder builder = new StringBuilder("The clinic has the following patients:");
        for (Pet pet : data
        ) {
            builder.append(System.lineSeparator());
            builder.append(String.format("%s %s",pet.getName(),pet.getOwner()));
        }
        return builder.toString();
    }
}
