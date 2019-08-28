package _09_String_And_Text_Processing.Lab;

import java.util.Scanner;

public class ReverseStrings_03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        while (!text.equals("end")) {
            String reversedString = "";

            for (int i = text.length() - 1; i >= 0; i--) {
                reversedString += text.charAt(i);
            }

            System.out.printf("%s = %s%n", text, reversedString);
            text = sc.nextLine();
        }
    }
}
