package RegularExpressions.Exercises;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma_05_Ver2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Set<String> attacked = new TreeSet<>();
        Set<String> destroyed = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            int add = 0;

            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 's' || line.charAt(j) == 'S' ||
                        line.charAt(j) == 't' ||
                        line.charAt(j) == 'T' ||
                        line.charAt(j) == 'a' ||
                        line.charAt(j) == 'A' ||
                        line.charAt(j) == 'r' ||
                        line.charAt(j) == 'R'
                ) {

                    add++;


                }
            }

            StringBuilder newString = new StringBuilder();

            for (int j = 0; j < line.length(); j++) {
                char c = (char) (line.charAt(j) + add);
                newString.append(c);
            }

            Pattern pattern = Pattern.compile
                (".*?@([A-Za-z]+)[^@\\-!:>]*:(\\d+)[^@\\-!:>]*!([AD])![^@\\-!:>]*->(\\d+)");
            Matcher matcher = pattern.matcher(newString);
            if (matcher.find()) {
                String planet = matcher.group(1);
                String type = matcher.group(3);
                if (type.equals("A")) {
                    attacked.add("-> " + planet);
                } else {
                    destroyed.add("-> " + planet);
                }
            }

            System.out.println("Attacked planets: " + attacked.size());
            if (!attacked.isEmpty()) {
                System.out.println(String.join(System.lineSeparator(), attacked));
            }

            System.out.println("Destroyed planets: " + destroyed.size());
            System.out.println(String.join(System.lineSeparator(), destroyed));
        }
    }
}
