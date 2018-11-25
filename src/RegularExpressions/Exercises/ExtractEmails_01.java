package RegularExpressions.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split("\\s+");
        List<String> listOfEmails = Arrays.asList(text);
        List<String> foundEmails = new ArrayList<>();

        listOfEmails.forEach(e -> {
            Pattern pattern = Pattern.compile("(?<user>[A-Za-z0-9](\\.|-)\\w+)@(?<host>\\w+\\.?\\w+(?=\\.)\\.\\w+)");
            Matcher matcher = pattern.matcher(e);

            while (matcher.find()) {
                if (!foundEmails.contains(matcher.group())) {
                    foundEmails.add(matcher.group());
                }
            }
        });

        System.out.println(String.join("\n",foundEmails));
    }
}
