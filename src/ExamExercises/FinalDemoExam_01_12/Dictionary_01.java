package ExamExercises.FinalDemoExam_01_12;

import java.util.*;

public class Dictionary_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> dictionary = new LinkedHashMap<>();
        List<String> listOfWords = new ArrayList<>();
        String input = sc.nextLine();

        while (true) {
            if (input.equals("End")) {
                /*Sort Map by Key and By Values fields length*/
                dictionary.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .forEach(k -> {
                            if (listOfWords.contains(k.getKey())) {
                                System.out.println(k.getKey());
                                k.getValue().stream().sorted((o1, o2) -> {
                                    int result = Integer.compare(o2.length(), o1.length());
                                    return result != 0 ? result : 1;
                                }).forEach(v -> System.out.printf(" -%s%n", v));
                            }
                        });

                break;
            }

            if (input.equals("List")) {
                dictionary.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .forEach(e -> System.out.printf("%s ", e.getKey()));

                break;
            }

            String[] words = input.split(" \\| ");
            if (words[0].contains(": ")) {

                for (int i = 0; i < words.length; i++) {
                    String[] tokens = words[i].split(": ");
                    dictionary.putIfAbsent(tokens[0], new ArrayList());
                    dictionary.get(tokens[0]).add(tokens[1]);
                }

            } else {
                listOfWords.addAll(Arrays.asList(words));
            }

            input = sc.nextLine();
        }
    }
}