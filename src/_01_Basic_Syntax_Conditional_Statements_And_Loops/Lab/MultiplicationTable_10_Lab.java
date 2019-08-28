package _01_Basic_Syntax_Conditional_Statements_And_Loops.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplicationTable_10_Lab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= 10; i++) {
            int product = n * i;
            System.out.printf("%TopInteger_05_Ver2 X %TopInteger_05_Ver2 = %TopInteger_05_Ver2%n", n, i, product);
        }
    }
}
