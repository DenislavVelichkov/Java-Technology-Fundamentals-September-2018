package _04_Methods_Functions.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromIntegers_09 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        while (!command.equals("END")) {

            char[] getFandS = getFirstAndLast(Integer.parseInt(command)).toCharArray();
            System.out.println(getFandS[0] == getFandS[1]);

            command = reader.readLine();
        }
    }

    private static String getFirstAndLast(int num) {
        int firstDigit = 0;
        int lastDigit = num % 10;
        String numbers;

        while (num > 0) {
            firstDigit = num % 10;
            num /= 10;
        }

        numbers = "" + firstDigit + lastDigit;
        return numbers;
    }
}
