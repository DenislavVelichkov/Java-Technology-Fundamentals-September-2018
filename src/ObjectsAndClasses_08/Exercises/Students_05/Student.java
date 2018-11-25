package ObjectsAndClasses_08.Exercises.Students_05;

public class Student {
    private String name;
    private String lastName;
    private float grade;

    Student(String name, String lastName, float grade) {
        this.name = name;
        this.lastName = lastName;
        this.grade = grade;
    }

    float getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    private String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", getName(), getLastName(), getGrade());
    }
}
