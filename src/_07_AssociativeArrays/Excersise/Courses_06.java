package _07_AssociativeArrays.Excersise;

import java.util.*;


public class Courses_06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();
        Map<String, ArrayList<String>> courseAndName = new LinkedHashMap<>();

        while (!command.equals("end")) {

                String[] token = command.split(":");
                String course = token[0];
                String name = token[1];

                courseAndName.putIfAbsent(course, new ArrayList<>());
                courseAndName.get(course).add(name);

            command = sc.nextLine();
        }

        courseAndName
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, ArrayList<String>>comparingByValue(Comparator.comparingInt(ArrayList::size))
                        .reversed())
                .forEach(entry -> {
                    String temp = String.valueOf(entry.getValue().size());

                    System.out.println
                            // removes " " before ":"
                                    (String.join("", entry.getKey().trim(), ": ", temp));

                    entry.getValue()
                            .stream()
                            .sorted(Comparator.comparing(String::new, Comparator.nullsFirst(String.CASE_INSENSITIVE_ORDER)))// same as (e1).CompareTo.(e2)
                            .forEach(e -> System.out.printf("--%s%n", e));
                });
    }
}
/*
.sorted(Comparator.nullsFirst(Comparator.comparing(String::new, Comparator.nullsFirst(String.CASE_INSENSITIVE_ORDER))))
 */
