package _08_Objects_And_Classes.Lab.CountryAndPerson;

class Person {
    String name;
    String lastName;
    int age;
    String PIN;

    public Person(String name, String lastName, int age, String PIN) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.PIN = PIN;
    }

    @Override
    public String toString() {
        return this.PIN + ": " + this.name + " " + this.lastName +
                " (" + this.age + ")";
    }
}