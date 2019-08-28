package _08_Objects_And_Classes.MoreExercises.CompanyRoster_01_Ver2;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(){
        this.employees = new ArrayList<>();
    }

    public Department(String name){
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee e){
        this.employees.add(e);
    }

    public double getAverage(){
        double res = 0.0;
        for(Employee e : this.employees)
            res += e.getSalary();
        return res / this.employees.size();
    }
}