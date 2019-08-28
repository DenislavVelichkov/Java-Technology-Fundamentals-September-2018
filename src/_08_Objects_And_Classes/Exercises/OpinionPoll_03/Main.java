package _08_Objects_And_Classes.Exercises.OpinionPoll_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayList<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] data = sc.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        people = people.stream().filter(p -> p.getAge() > 30)
                .collect(Collectors.toCollection(ArrayList::new));
        people.stream()
                /*(f, s ) -> f.getName().compareTo(s.getName())*/
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.toString()));
    }
}
