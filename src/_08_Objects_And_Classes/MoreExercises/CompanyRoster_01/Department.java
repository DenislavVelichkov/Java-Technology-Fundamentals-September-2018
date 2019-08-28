package _08_Objects_And_Classes.MoreExercises.CompanyRoster_01;

import java.util.ArrayList;
import java.util.List;

class Department {
    private String name;
    private List<Employee> employeeInDepartment;

    Department(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    Department() {
        this.employeeInDepartment = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employeeInDepartment.add(employee);
    }

    public List<Employee> getEmployeeInDepartment() {
        return employeeInDepartment;
    }

    public double getAvg() {
        double sum = 0.0;

        for (Employee person : this.employeeInDepartment) {
            sum += person.getSalary();
        }

        return sum / employeeInDepartment.size();
    }
}
