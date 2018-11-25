package StringAndTextProcessing_09.Exercises;

import java.util.Scanner;

public class ReplaceRepeatingChars_06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String result = "";
        char prev = text.charAt(0);
        result += prev;

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (prev != symbol) {
                prev = symbol;
                result += prev;
            }
        }

        System.out.println(result);
    }
}
