package _09_String_And_Text_Processing.Lab;

import java.util.Scanner;

public class TextFilter_04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] toReplace = sc.nextLine().split(", ");
        String text = sc.nextLine();

        for (String str : toReplace) {
            String stars = str.replaceAll(".", "*");
            text = text.replace(str, stars);
        }

        System.out.println(text);
    }
}
