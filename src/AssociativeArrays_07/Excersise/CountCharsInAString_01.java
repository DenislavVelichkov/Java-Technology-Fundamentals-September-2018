package AssociativeArrays_07.Excersise;

import java.util.*;

public class CountCharsInAString_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine().replaceAll(" ", "");

        List<String> strByChar = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            strByChar.add(String.valueOf(text.charAt(i)));
        }

        Map<String, Integer> mapCount = new LinkedHashMap<>();
        for (String character : strByChar) {
            mapCount.putIfAbsent(character, 0);
            mapCount.put(character, mapCount.get(character) + 1);
        }

        for (var s : mapCount.entrySet()) {
            System.out.printf("%s -> %s%n", s.getKey(), s.getValue());
        }
    }
}
