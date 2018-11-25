package ObjectsAndClasses_08.Exercises.OrderByAge_07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        while (true) {
            String line = sc.nextLine();
            String[] data = line.split(" ");

            if (data.length > 1) {
                Person person = new Person(data[0], data[1], Integer.parseInt(data[2]));
                people.add(person);
            }

            if (line.equals("End")) {
                break;
            }
        }

        people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(person -> System.out.println(person.toString()));
    }
}
