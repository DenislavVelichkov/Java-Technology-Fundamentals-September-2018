package ObjectsAndClasses_08.MoreExercises.CompanyRoster_01;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, Department> departments = new LinkedHashMap<>();

        /*name, salary, position, department, email and age*/
        while (n > 0) {
            String[] data = sc.nextLine().split("\\s+");
            Employee employee = new Employee(
                    data[0], Double.parseDouble(data[1]), data[2], data[3]);


            if (data.length > 4) {
                if (data[4].contains("@")) {
                    employee.setEmail(data[4]);
                } else {
                    employee.setAge(Integer.parseInt(data[4]));
                }
                try {
                    if (!data[5].isEmpty()) {
                        employee.setAge(Integer.parseInt(data[5]));
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    employee.setAge(employee.getAge());
                }
            }

            String departmentName = employee.getDepartment();

            departments.putIfAbsent(departmentName, new Department(data[3]));
            departments.get(departmentName).addEmployee(employee);

            n--;
        }

        List<Department> sortedDepartment = departments
                .values()
                .stream()
                /*(e1, e2) -> Double.compare(e1.getAvg(), e2.getAvg())*/
                .sorted(Comparator.comparingDouble(Department::getAvg).reversed())
                .collect(Collectors.toList());

        Department bestDepartment = sortedDepartment.get(0);
        System.out.printf("Highest Average Salary: %s%n", bestDepartment.getName());

        List<Employee> sortedEmployeesInDepartment = bestDepartment
                .getEmployeeInDepartment()
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        for (Employee employee : sortedEmployeesInDepartment) {
            System.out.printf("%s %.2f %s %d%n",
                employee.getName(),
                employee.getSalary(),
                employee.getEmail(),
                employee.getAge());
        }
    }
}
