package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoublePredicate;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Department> departments = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            String email;
            int age;
            Employee employee = null;
            departments.putIfAbsent(department, new Department());
            if (tokens.length == 6) {
                email = tokens[4];
                age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (tokens.length == 5) {
                if (tokens[4].matches("^\\d+$")) {
                    age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }
            departments.get(department).employeeList.add(employee);

        }
        String bestDep = "";
        double bestSalary = Integer.MIN_VALUE;
        for (Map.Entry<String, Department> entry : departments.entrySet()) {
            if (entry.getValue().getAverageSalary() > bestSalary) {
                bestDep = entry.getKey();
                bestSalary = entry.getValue().getAverageSalary();
            }
        }
        System.out.println("Highest Average Salary: "+bestDep);
        for (Map.Entry<String, Department> entry : departments.entrySet()) {
            if (entry.getKey().equals(bestDep)) {
                entry.getValue().employeeList.sort((s1, s2) -> Double.compare(s2.getSalary(), s1.getSalary()));
                entry.getValue().employeeList.forEach(s -> System.out.printf("%s %.2f %s %d%n", s.getName(), s.getSalary(), s.getEmail(), s.getAge()));
            }
        }
    }
}
