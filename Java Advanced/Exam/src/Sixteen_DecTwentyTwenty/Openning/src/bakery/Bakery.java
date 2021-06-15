package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }
    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }
    public boolean remove(String name) {
        return employees.removeIf(s -> s.getName().equals(name));
    }

    public int getCount() {
        return employees.size();
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().sorted((s1, s2) -> Integer.compare(s2.getAge(), s1.getAge())).findFirst().orElse(null);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }


    public String report() {
        StringBuilder builder = new StringBuilder(String.format("Employees working at Bakery %s:",this.name));
        for (Employee employee : employees
        ) {
            builder.append(System.lineSeparator());
            builder.append(employee.toString());
        }
        return builder.toString();
    }

}
