package _01_Basic_Syntax_Conditional_Statements_And_Loops.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrongNumber_06Ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String numbersAsString = reader.readLine();
        int number = Integer.parseInt(numbersAsString);

        int sum = 0;

        for (int i = 0; i < numbersAsString.length(); i++) { //convert number into string
            int digit = numbersAsString.charAt(i);

            int factorial = 1;

            for (int j = 1; j <= digit; j++) {
                factorial *= j;
            }

            sum += factorial;
        }

        if (sum == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
