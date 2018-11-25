package ObjectsAndClasses_08.Exercises.OpinionPoll_03;

public class Person {
   private String name;
   private int age;

   public Person(String name, int age) {
        this.age = age;
        this.name = name;
   }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.getName(), this.getAge());
    }
}
