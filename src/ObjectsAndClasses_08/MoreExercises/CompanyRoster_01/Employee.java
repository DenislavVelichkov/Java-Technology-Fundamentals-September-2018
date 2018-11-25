package ObjectsAndClasses_08.MoreExercises.CompanyRoster_01;

public class Employee extends Department {
    private static final String DEFAULT_MAIL = "n/a";
    private static final int DEFAULT_AGE = -1;

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position,
                    String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.setEmail(DEFAULT_MAIL);
        this.setAge(DEFAULT_AGE);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }
}
