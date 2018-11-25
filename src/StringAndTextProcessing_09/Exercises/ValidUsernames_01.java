package StringAndTextProcessing_09.Exercises;

import java.util.Scanner;

public class ValidUsernames_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(", ");
        for (String str : text) {
            if (isValid(str)) {
                System.out.println(str);
            }

        }
    }

    public static boolean isValid(String string) {
        if (string.length() < 3 || string.length() > 16) {
            return false;
        }
        for (int i = 0; i < string.length(); i++) {
            char symbol = string.charAt(i);

            if (!(Character.isLetterOrDigit(symbol) ||
                    symbol == '-' || symbol == '_')) {

                return false;
            }
        }

        return true;
    }
}
