package _09_String_And_Text_Processing.Lab;

import java.util.Scanner;

public class DigitsLetterAndOthers_05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        StringBuilder onlyLetters = new StringBuilder();
        StringBuilder onlyDigits = new StringBuilder();
        StringBuilder onlyOthers = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            if (Character.isDigit(text.charAt(i))) {
                onlyDigits.append(text.charAt(i));
            } else if (Character.isLetter(text.charAt(i))) {
                onlyLetters.append(text.charAt(i));
            } else {
                onlyOthers.append(text.charAt(i));
            }


        }

        System.out.println(onlyDigits);
        System.out.println(onlyLetters);
        System.out.println(onlyOthers);
    }
}
