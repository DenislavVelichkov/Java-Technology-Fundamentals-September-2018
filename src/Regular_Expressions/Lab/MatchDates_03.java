package Regular_Expressions.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates_03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] text = sc.nextLine().split(", ");
        List<String> dates = Arrays.asList(text);

        dates.forEach(e -> {
            Pattern pattern = Pattern.compile
                ("\\b(?<day>\\d{2})\\b([-.\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b");
            Matcher matcher = pattern.matcher(e);

            while (matcher.find()) {
                String day = matcher.group("day");
                String month = matcher.group("month");
                String year = matcher.group("year");

                System.out.printf("Day: %s, Month: %s, Year: %s%n",day, month, year);
            }
        });
    }
}
