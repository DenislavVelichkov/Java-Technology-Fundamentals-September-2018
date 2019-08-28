package _07_AssociativeArrays.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences_03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> words = Arrays.stream(sc.nextLine().toLowerCase().split(" "))
                .collect(Collectors.toList());

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            counts.putIfAbsent(word, 0);
            counts.put(word, counts.get(word) + 1);
        }

        List<String> odds = new ArrayList<>();

        for (var entry : counts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                odds.add(entry.getKey());
            }
        }

        for (int i = 0; i < odds.size(); i++) {
            System.out.print(odds.get(i));
            if (i < odds.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
