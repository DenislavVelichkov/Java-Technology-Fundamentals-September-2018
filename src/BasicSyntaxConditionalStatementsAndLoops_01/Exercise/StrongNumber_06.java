package BasicSyntaxConditionalStatementsAndLoops_01.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrongNumber_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());

        int factorial = 1;
        int factorialsSum = 0;

        String numberArray = String.valueOf(number);

        for (int i = 0; i < numberArray.length(); i++) {

            for (int j = 1; j <= Character.digit(numberArray.charAt(i), 10); j++) { //number division in array
                factorial *= j;
            }
            factorialsSum += factorial;
            factorial = 1;
        }

        if (factorialsSum == number)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}

