package Methods_Functions_04.Exercises;

import java.util.Scanner;

public class PasswordValidator_04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean flag = false;

        char[] password = sc.nextLine().toCharArray();


        for (int i = 0; i < password.length; i++) {
            if (validatePass(password[i])) {
                flag = true;

            } else {
                System.out.println("Password must consist only of letters and digits");
                break;
            }

        }

        if (flag && validatePass(password)) {
            System.out.println("Password is valid");
        }
    }

    private static boolean validatePass(char[] array) {
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i])) {
                counter++;
            }
        }

        boolean checkLength = (array.length >= 6 && array.length <= 10);
        if (checkLength && (counter >= 2)) {
            return true;
        } else {
            if (checkLength) {
                System.out.println("Password must have at least 2 digits");
                return false;
            } else if (counter >= 2) {
                System.out.println("Password must be between 6 and 10 characters");
                return false;
            }else {
                System.out.println("Password must be between 6 and 10 characters");
                System.out.println("Password must have at least 2 digits");
                return false;
            }

        }
    }

    private static boolean validatePass(char c) {
        boolean flag = false;
        if (Character.isDigit(c) || Character.isAlphabetic(c)) {
            flag = true;
        }

        return flag;
    }
}

