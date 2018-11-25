package RegularExpressions.Exercises;

import java.util.*;

public class Race_03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        List<String> letters = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();
        Map<String, Integer> list = new LinkedHashMap<>();
        String name;
        int distanceRan = 0;

        while (!line.equals("end of race")) {
            String[] tokens = line.split(", ");

            if (tokens.length == 1) {
                String[] text = line.split("[^A-Za-z0-9]");

                for (int i = 0; i < text.length; i++) {
                    int size = text[i].length();

                    for (int j = 0; j < size; j++) {
                        if (Character.isLetter(text[i].charAt(j))) {
                            letters.add(String.valueOf(text[i].charAt(j)));
                        } else {
                            digits.add(Integer.parseInt(String.valueOf(text[i].charAt(j))));
                        }
                    }
                }

                name = joinLetters(letters);
                distanceRan = joinDigits(digits);

                if (list.containsKey(name)) {
                    list.put(name, list.get(name) + distanceRan);
                }

                letters.clear();
                digits.clear();


                
            } else {
                for (int i = 0; i < tokens.length; i++) {
                    list.putIfAbsent(tokens[i], 0);
                }
            }

            line = sc.nextLine();
        }

        Map<String, Integer> sortedPlayers = new LinkedHashMap<>();
        list.entrySet().stream()
                .sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    sortedPlayers.putIfAbsent(e.getKey(), 0);
                    sortedPlayers.put(e.getKey(), e.getValue());
                });

        Object[] leaders =  sortedPlayers.keySet().toArray();
        System.out.printf("1st place: %s%n", leaders[0]);
        System.out.printf("2nd place: %s%n", leaders[1]);
        System.out.printf("3rd place: %s", leaders[2]);
    }

    private static int joinDigits(List<Integer> digits) {
        int sum = 0;
        for (Integer digit : digits) {
            sum += digit;
        }
        return sum;
    }

    private static String joinLetters(List<String> letters) {
        String name = "";
        for (String letter : letters) {
            name += letter;
        }
        return name;
    }
}
