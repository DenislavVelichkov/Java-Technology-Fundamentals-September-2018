package Regular_Expressions.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchNuimbers_04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*(^|(?!\s))-?\d+(\.\d+)?($|(?=\s))*/
        String[] text = sc.nextLine().split(", ");
        List<String> numbers = Arrays.asList(text);
        List<String> formatedNumbers = new ArrayList<>();

        numbers.forEach(e -> {
            Pattern pattern = Pattern.compile
                    ("(^|(?<=\\s))-?\\d+(\\.\\d+)?($|(?=\\s))");
            Matcher matcher = pattern.matcher(e);

            while (matcher.find()) {
                formatedNumbers.add(matcher.group());
            }
        });

        System.out.printf(String.join(" ", formatedNumbers));
    }
}
