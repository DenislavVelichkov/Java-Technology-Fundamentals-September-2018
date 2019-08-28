package _04_Methods_Functions.Exercises;

import java.util.Scanner;

public class PasswordValidator_04_Ver2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String password = sc.nextLine();

        boolean test3 = validatePassLength(password);
        boolean test1 = validateLettersAndDigits(password);
        boolean test2 = validateDigits(password);

        if (test1 && test2 && test3)
            System.out.println("Password is valid");
    }

    private static boolean validatePassLength(String array) {
        char[] strToArray = array.toCharArray();

        if (strToArray.length >= 6 && strToArray.length <= 10) {
            return true;

        } else {
            System.out.println("Password must be between 6 and 10 characters");
        }
        return false;

    }

    private static boolean validateLettersAndDigits(String str) {
        char[] strToArray = str.toCharArray();
        boolean flag = false;

        for (int i = 0; i < strToArray.length; i++) {
            if (Character.isDigit(strToArray[i]) || Character.isLetter(strToArray[i])) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            return true;
        } else {
            System.out.println("Password must consist only of letters and digits");
            return false;
        }
    }

    private static boolean validateDigits(String str) {
        char[] array = str.toCharArray();
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i])) {
                counter++;
            }
        }

        if (counter >= 2) {
            return true;
        } else {
            System.out.println("Password must have at least 2 digits");
        }

        return false;
    }
}