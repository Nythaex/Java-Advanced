package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(s -> s.getManufacturer().equals(manufacturer) && s.getModel().equals(model));
    }

    public int getCount() {
        return data.size();
    }

    public Car getLatestCar() {
        return this.data.stream().sorted((s1, s2) -> Integer.compare(s2.getYear(), s1.getYear())).findFirst().orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(s -> s.getManufacturer().equals(manufacturer) && s.getModel().equals(model)).findFirst().orElse(null);
    }


    public String getStatistics() {
        StringBuilder builder = new StringBuilder(String.format("The cars are parked in %s:", getType()));
        for (Car car : data
        ) {
            builder.append(System.lineSeparator());
            builder.append(car.toString());
        }
        return builder.toString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }
}
