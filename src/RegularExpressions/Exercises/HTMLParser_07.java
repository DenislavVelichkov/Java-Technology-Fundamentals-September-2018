package RegularExpressions.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLParser_07 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        Pattern title = Pattern.compile("(?<=<title>)([A-Za-z0-9\\s]+)");
        Matcher matchTitle = title.matcher(text);
        Pattern content = Pattern.compile("(?<=<body>)(.)*(?=<a)|(?<=\">)(.)*(?=<\\/body>)");
        Matcher matchContent = content.matcher(text);

        while (matchTitle.find()) {
            System.out.printf("Title: %s%n", matchTitle.group());
        }
        List<String> formatedContent = new ArrayList<>();
        while (matchContent.find()) {
            /*String finalContent = matchContent.group();*/
            formatedContent.add(matchContent.group());
        }
        System.out.print("Content: ");
        formatedContent.forEach(e -> System.out.printf("%s",e.replaceAll("([\\<\\/\\>]+(?<=<\\/|)[a-z]+\\>)|(\\\\n)", " ")));
/*
        System.out.println("Content: " + finalContent.replaceAll("[<\\/p>]+|(\\\\n)", " "));
*/

    }
}
