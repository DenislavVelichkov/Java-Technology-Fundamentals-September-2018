package _08_Objects_And_Classes.Lab.CountryAndPerson;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Person>> peopleByCountry = new HashMap<>();

        String line = sc.nextLine();

        while (!line.equals("end")) {
            String[] tokens = line.split(" ");
            if (tokens.length == 5) {
                String country = tokens[0];
                String name = tokens[1];
                String lastName = tokens[2];
                int age = Integer.parseInt(tokens[4]);
                String PIN = tokens[3];

                peopleByCountry.putIfAbsent(country, new ArrayList<>());
                Person person = new Person(name, lastName, age, PIN);
                peopleByCountry.get(country).add(person);
                System.out.println("We have added " + person + " into " + country);
            } else {
                tokens = line.split("-");
                String cmd = tokens[2];
                String country = tokens[0];
                String PIN = tokens[1];
                String fielToChane = tokens[3];
                String value = tokens[4];

                /*List<Person> peopleInTheCountry = peopleByCountry.get(country);
                Person locatedPerson = null;
                for (Person person : peopleInTheCountry) {
                    if (person.PIN.equals(PIN)) {
                        locatedPerson = person;
                        break;
                    }
                }*/
                Person locatedPerson = peopleByCountry.get(country).stream()
                        .filter(person -> person.PIN.equals(PIN))
                        .findFirst()
                        .get();

                switch (cmd) {
                    case "add":
                        switch (fielToChane) {
                            case "name":
                                locatedPerson.name += value;
                                break;
                            case "lastName":
                                locatedPerson.lastName += value;
                                break;
                            case "age":
                                locatedPerson.age += Integer.parseInt(value);
                                break;
                        }
                        break;
                    case "change":
                        switch (fielToChane) {
                            case "name":
                                locatedPerson.name = value;
                                break;
                            case "lastName":
                                locatedPerson.lastName = value;
                                break;
                            case "age":
                                locatedPerson.age = Integer.parseInt(value);
                                break;
                        }
                    default:
                        break;
                }
            }

            line = sc.nextLine();
        }

        peopleByCountry.entrySet().stream().sorted((es1, es2) -> {
            int count1 = es1.getValue().size();
            int count2 = es2.getValue().size();
            if (count1 == count2) {
                return es1.getKey().compareTo(es2.getKey());
            }
            return Integer.compare(count2, count1);
        })
                .forEach(es -> {
                    System.out.println("Country: " + es.getKey());
                    es.getValue().sort((p1, p2) -> p1.PIN.compareTo(p2.PIN));
                    es.getValue().forEach(System.out::println);
                });
        /*peopleByCountry.forEach((country, people) -> {
            System.out.printf("Country: " + country);
            people.forEach(System.out::println);
        });*/
    }
}