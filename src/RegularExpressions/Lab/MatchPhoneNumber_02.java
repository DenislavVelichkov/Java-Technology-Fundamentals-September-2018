package RegularExpressions.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(", ");
        List<String> phoneNumbers = Arrays.asList(text);
        List<String> matchedPhones = new ArrayList<>();
        phoneNumbers.forEach(e -> {
            /*Alt + Enter - > check regex expression tests regexes on the fly*/
            Pattern pattern = Pattern.compile("\\+359([ |-])2\\1\\d{3}\\1\\d{4}\\b");
            Matcher matcher = pattern.matcher(e);

            while (matcher.find()) {
                matchedPhones.add(matcher.group());
            }
        });
        System.out.print(String.join(", ",matchedPhones));
    }
}
