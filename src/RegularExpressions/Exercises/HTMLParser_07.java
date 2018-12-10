package RegularExpressions.Exercises;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLParser_07 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        Pattern title = Pattern.compile("(?<=<title>).*(?=</title>)");
        Matcher matchTitle = title.matcher(text);
        Pattern content = Pattern.compile("(?<=<body>).*(?=</body>)");
        Matcher matchContent = content.matcher(text);

        String titleText = "";
        String bodyText = "";

        if (matchTitle.find()) {
            titleText = matchTitle.group();
        }
        if (matchContent.find()) {
            bodyText = matchContent.group();
        }

        String readyToSplitBody = stripFromTags(bodyText);
        String readyToSplitTitle = stripFromTags(titleText);

        String[] splitterBody = readyToSplitBody.split(" ");
        String[] splitterTitle = readyToSplitTitle.split(" ");

        ArrayList<String> tempBody = new ArrayList<>(Arrays.asList(splitterBody));
        tempBody.removeIf(String::isEmpty);

        ArrayList<String> tempTitle = new ArrayList<>(Arrays.asList(splitterTitle));
        tempTitle.removeIf(String::isEmpty);

        System.out.printf("Title:%s%n", finalText(tempTitle));
        System.out.printf("Content:%s%n", finalText(tempBody));
    }

    private static String finalText(List<String> text) {
        StringBuilder string = new StringBuilder();
        for (String cluster : text) {
            string.append(" ").append(cluster);
        }
        return string.toString();
    }

    private static String stripFromTags(String text) {
        int indexOfOpenTag = text.indexOf("<");
        int indexOfCloseTag = text.indexOf(">") + 1;
        String toRemove;
        try {
            toRemove = text.substring(indexOfOpenTag, indexOfCloseTag);
            String innerTagToReplace = "\\\\\\w{1}";
            text = text.replaceAll(innerTagToReplace, " ");
        } catch (Exception e) {
            return text;
        }

        while (text.contains(toRemove)) {
            text = text.replace(toRemove, " ");

            indexOfOpenTag = text.indexOf("<");
            indexOfCloseTag = text.indexOf(">") + 1;

            try {
                toRemove = text.substring(indexOfOpenTag, indexOfCloseTag);
            } catch (StringIndexOutOfBoundsException e) {
                text = text.replaceAll("<\\/[a-z]+>?|[0-9]+", "");
                break;
            }
        }
        return text;
    }
}