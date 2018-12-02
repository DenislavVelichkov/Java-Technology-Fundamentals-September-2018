package Exams.FinalDemoExam_01_12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cipher = sc.nextLine();
        String[] key = sc.nextLine().split(" ");

        if (checkForValidBook(cipher)) {
            String decryptedMassage = decryptCipher(cipher);
            String massage = massage(decryptedMassage, key);
            System.out.print(massage);
        } else {
            System.out.print("This is not the book you are looking for.");
        }
    }

    private static boolean checkForValidBook(String cipher) {
        Pattern pattern = Pattern.compile("[d-z{}|#]+");
        Matcher matcher = pattern.matcher(cipher);

        if (matcher.matches()) {
            return true;
        }

        return false;
    }

    private static String massage(String decryptedCipher, String[] key) {
        String[] splitCipher = decryptedCipher.split(" ");
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < splitCipher.length; i++) {
            if (splitCipher[i].contains(key[0])) {
                str.append(splitCipher[i].replaceAll(key[0], key[1]) + " ");
            } else {
                str.append(splitCipher[i] + " ");
            }
        }

        return str.toString();
    }

    private static String decryptCipher(String cipher) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {
            char character = (char) (cipher.charAt(i) - 3);
            str.append(character);
        }

        return String.valueOf(str);
    }
}
