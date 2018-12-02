package AssociativeArrays_07.MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ranking_01_Without_Class {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String contestAndPass = sc.nextLine();
        Map<String, String> contestContainer = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> userDB = new LinkedHashMap<>();

        while (!contestAndPass.equals("end of contests")) {
            String[] tokens = contestAndPass.split(":");
            contestContainer.putIfAbsent(tokens[0], "");
            contestContainer.put(tokens[0], tokens[1]);

            contestAndPass = sc.nextLine();
        }

        String submissions = sc.nextLine();
        while (!submissions.equals("end of submissions")) {
            String[] tokens = submissions.split("=>");

            if ((contestContainer.containsKey(tokens[0])) &&
                (tokens[1].equals(contestContainer.get(tokens[0])))) {
                userDB.putIfAbsent(tokens[2], new LinkedHashMap<>());
                userDB.get(tokens[2]).putIfAbsent(tokens[0], 0);
                if (userDB.get(tokens[2]).get(tokens[0]) <
                        Integer.parseInt(tokens[3])) {
                    userDB.get(tokens[2]).put(tokens[0],
                        Integer.parseInt(tokens[3]));
                }

            }

            submissions = sc.nextLine();
        }

        String topScorer = "";
        int temp = 0;
        for (Map.Entry<String, Map<String, Integer>>
                entry : userDB.entrySet()) {
            int sum = entry.getValue().values().stream()
                    .mapToInt(integer -> integer).sum();

            if (temp < sum) {
                temp = sum;
                topScorer = entry.getKey();
            }

        }

        System.out.printf("Best candidate is %s with total %d points." +
                "%nRanking:%n", topScorer, temp);

        userDB.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.printf("%s%n", entry.getKey());

                    entry.getValue().entrySet().stream()
                            .sorted((o1, o2) -> {
                            int result = o2.getValue().compareTo(o1.getValue());
                            return result != 0 ? result : 1;
                    }).forEach(v -> {
                        System.out.printf("#  %s -> %d%n",
                                v.getKey(), v.getValue());
                    });
                });
    }
}
