package _01_Basic_Syntax_Conditional_Statements_And_Loops.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Division_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int[] divisor = {2, 3, 6, 7, 10};

        double max = -Double.MAX_VALUE;
        boolean flag = false;

        for (double element : divisor) {
            if (number % element == 0) {
                flag = true;

                if (element > max) {
                    max = element;

                }
            }
        }
        if (flag)
            System.out.printf("The number is divisible by %.0f", max);

        else System.out.println("Not divisible");
    }
}