package _09_String_And_Text_Processing.Exercises;

import java.util.Scanner;

public class StringExplosion_07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (symbol == '>') {
                result += symbol;
                i++;
                int expln = text.charAt(i) - '0';
                expln--;

                while (expln > 0 && i < text.length() - 1) {
                    i++;
                    symbol = text.charAt(i);

                    if (symbol == '>') {
                        result += symbol;
                        i++;
                        expln += text.charAt(i) - '0';
                        expln--;
                        continue;
                    }

                    expln--;
                }
            } else {
                result += symbol;
            }
        }
        System.out.println(result);
    }
}
