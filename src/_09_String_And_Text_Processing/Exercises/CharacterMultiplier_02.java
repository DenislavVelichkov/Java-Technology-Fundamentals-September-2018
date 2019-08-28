package _09_String_And_Text_Processing.Exercises;

import java.util.Scanner;

public class CharacterMultiplier_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(" ");

        int result = multiplyChar(text[0], text[1]);


        System.out.println(result);
    }

    private static int multiplyChar(String first, String second) {
        int result = 0;
        int length = Math.min(first.length(), second.length());

        for (int i = 0; i < length; i++) {
            result += first.charAt(i) * second.charAt(i);
        }

        if (first.length() > second.length()) {
            for (int i = length; i < first.length(); i++) {
                result += first.charAt(i);
            }
        } else {
            for (int i = length; i < second.length(); i++) {
                result += second.charAt(i);
            }
        }

        return result;
    }
}
