package ObjectsAndClasses_08.Exercises.OrderByAge_07;

public class Person {
    private String name;
    private String ID;
    private int age;

    Person(String name, String ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    private String getID() {
        return ID;
    }

    int getAge() {
        return age;
    }
//Stefan with ID: 524244 is 10 years old.
    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.",
                getName(), getID(), getAge());
    }
}
