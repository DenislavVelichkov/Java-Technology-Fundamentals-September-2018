package RegularExpressions.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma_05 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Map<String, List<String>> planets = new TreeMap<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String text = reader.readLine();

            int lettersCount = countLetters(text);
            List<Character> decryptedMassage = decryptMsg(text, lettersCount);
            String tokensToBeSplit = "";

            decryptedMassage.removeIf(Objects::isNull);

            for (int i = 0; i < decryptedMassage.size(); i++) {
                tokensToBeSplit += decryptedMassage.get(i);
            }

            Pattern pattern = Pattern.compile
            ("(?<name>(?<=@)[A-Za-z]+)[^@\\-!:>]*|(?<population>(?<=:)[0-9]+)[^@\\-!:>]*|(?<attOrDef>(?<=!)[AD])[^@\\-!:>]*|(?<soldiers>(?<=->)[0-9]+)|");
            /*@([a-zA-Z]+)[^@\-!:>]*:[0-9]+[^@\-!:>]*!([AD])![^@\-!:>]*->[0-9]+  Изкопах го от нета, ама пак не става*/
            Matcher matcher = pattern.matcher(tokensToBeSplit);

            String planetName = "";
            String population = "";
            String attOrDef = "";
            String soldiersCount = "";

            while (matcher.find()) {
                if (matcher.group("name") != null) {
                    planetName = matcher.group("name");
                }
                if (matcher.group("population") != null) {
                    population = matcher.group("population");
                }
                if (matcher.group("attOrDef") != null) {
                    attOrDef = matcher.group("attOrDef");
                }
                if (matcher.group("soldiers") != null) {
                    soldiersCount = matcher.group("soldiers");
                }
            }

            planets.putIfAbsent(attOrDef, new ArrayList<>());
            if (!(planetName.isEmpty()) && !(population.isEmpty()) &&
                    !(attOrDef.isEmpty()) && !(soldiersCount.isEmpty())) {
                planets.get(attOrDef).add(planetName);

            }
        }

        Map<String, List<String>> sortedPlanets = new LinkedHashMap<>();
        planets.forEach((key, value) -> {
            Collections.sort(value);
            sortedPlanets.putIfAbsent(key, new ArrayList<>());
            sortedPlanets.put(key, value);
        });
        /*Може да използвам 2 хаш мапа, вместо този мармалад..*/
        for (Map.Entry<String, List<String>> entry : sortedPlanets.entrySet()) {
            if (entry.getKey().equals("A")) {
                System.out.printf("Attacked planets: %d%n",
                        sortedPlanets.get("A").size());

                if (!sortedPlanets.get("A").isEmpty()) {
                    for (int i = 0; i < sortedPlanets.get("A").size(); i++) {
                        System.out.printf("-> %s%n",
                                sortedPlanets.get("A").get(i).replaceAll("[\\[\\]]", ""));
                    }
                }
            } else if (entry.getKey().equals("D")) {
                System.out.printf("Destroyed planets: %d%n",
                        sortedPlanets.get("D").size());

                if (!sortedPlanets.get("D").isEmpty()) {
                    for (int i = 0; i < sortedPlanets.get("D").size(); i++) {
                        System.out.printf("-> %s%n",
                                sortedPlanets.get("D").get(i).replaceAll("[\\[\\]]", ""));
                    }
                }
            }
        }
    }

    private static List<Character> decryptMsg(String text, int lettersCount) {
        List<Character> decryptedList = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            decryptedList.add((char) (text.charAt(i) - lettersCount));
        }
        return decryptedList;
    }

    private static int countLetters(String text) {
        List<String> lettersCount = Arrays.asList(text.split("[^SsTtAaRr]+"));
        int sum = 0;

        for (String s : lettersCount) {
            sum += s.length();
        }

        return sum;
    }

}
