package RegularExpressions.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms_06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Map<String, Integer> demonsAndHealth = new TreeMap<>();
        Map<String, Double> demonsAndDmg = new TreeMap<>();
        String[] diffDemons = input.split("[,\\s]+");

        for (int i = 0; i < diffDemons.length; i++) {
            String demonName = diffDemons[i];

            if (checkName(diffDemons[i])) {
                demonsAndHealth.putIfAbsent(demonName, 0);
                demonsAndDmg.putIfAbsent(demonName, 0.0);

                int health = addDemonHealth(diffDemons[i]);
                double dmg = addDamage(diffDemons[i]);

                demonsAndHealth.put(demonName, health);
                demonsAndDmg.put(demonName, dmg);
            }

        }

        demonsAndHealth.forEach((s, integer) -> {
            System.out.printf("%s - %d health, %.2f damage%n", s, integer, demonsAndDmg.get(s));
        });
    }

    private static double addDamage(String diffDemon) {
        double sum = 0.0;
        String[] tokensDigits = diffDemon.split("[^0-9-+\\.]+");
        String[] tokensMultOrDevide = diffDemon.split("[^*\\\\]+");

        for (int i = 0; i < tokensDigits.length; i++) {
            if (!tokensDigits[i].isEmpty()) {
                sum += Double.parseDouble(tokensDigits[i]);
            }
        }

        for (int i = 0; i < tokensMultOrDevide.length; i++) {
            if (!tokensMultOrDevide[i].isEmpty()) {
                for (int j = 0; j < tokensMultOrDevide[i].length(); j++) {
                    String charSeq = tokensMultOrDevide[i];
                    if (charSeq.charAt(j) == '*') {
                        sum *= 2;
                    } else {
                        sum /= 2;
                    }
                }
            }
        }

        return sum;
    }

    private static int addDemonHealth(String diffDemon) {
        int sum = 0;

        for (int i = 0; i < diffDemon.length(); i++) {
            if (Character.isLetter(diffDemon.charAt(i))) {
                sum += diffDemon.charAt(i);
            }
        }

        return sum;
    }

    private static boolean checkName(String input) {
        Pattern pattern = Pattern.compile("[A-Za-z]+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            if (matcher.group().matches("[A-Za-z]+")) {
                return true;
            }
        }

        return false;
    }
}
