package CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    List<Employee> employeeList;

    public Department() {
        employeeList = new ArrayList<>();
    }

    public void addEmp(String name, Employee employee) {
        this.name = name;
        employeeList.add(employee);
    }

    public double getAverageSalary() {
        return this.employeeList.stream().mapToDouble(p->p.getSalary()).average().orElse(0d);
    }


}
