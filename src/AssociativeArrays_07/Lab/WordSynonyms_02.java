package AssociativeArrays_07.Lab;

import java.util.*;

public class WordSynonyms_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> synonyms = new LinkedHashMap<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            String synonym = sc.nextLine();
            synonyms.putIfAbsent(word, new ArrayList<>());
            synonyms.get(word).add(synonym);
        }

        synonyms.forEach((s, strings) -> {

            System.out.print(s + " - ");
            System.out.println(String.join(", ", strings));
        });

    }
}