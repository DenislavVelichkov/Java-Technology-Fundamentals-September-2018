package ObjectsAndClasses_08.MoreExercises.CompanyRoster_01_ver3;

import java.util.ArrayList;
import java.util.List;

class Department {
    private String name;
    private List<Employee> employeeInDepartment;

    public String getName() {
        return name;
    }

    Department() {
        this.employeeInDepartment = new ArrayList<>();
    }

    Department(String name) {
        this();
        this.name = name;
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
