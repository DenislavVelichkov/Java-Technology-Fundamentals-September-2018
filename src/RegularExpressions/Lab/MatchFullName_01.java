package RegularExpressions.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*www.regex101.com*/
public class MatchFullName_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(", ");
        List<String> names = Arrays.asList(text);
        names.forEach(e -> {
            /*Alt + Enter - > check regex expression tests regexes on the fly*/
            Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");
            Matcher matcher = pattern.matcher(e);
            while (matcher.find()) {
                System.out.print(matcher.group() + " ");
            }
        });
    }
}
