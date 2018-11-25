package StringAndTextProcessing_09.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractFile_03_Ver2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        String file = path.substring(path.lastIndexOf("\\") + 1);
        Pattern pattern = Pattern.compile("(.*)\\.(.*)"); // devide the regex by 2 groups
        Matcher matcher = pattern.matcher(file);

        if (matcher.find()) {
            System.out.printf("File name: %s%n", matcher.group(1));
            System.out.printf("File extension: %s%n", matcher.group(2));
        }
    }
}
