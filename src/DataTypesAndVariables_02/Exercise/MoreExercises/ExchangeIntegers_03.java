package DataTypesAndVariables_02.Exercise.MoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExchangeIntegers_03 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());

        System.out.println("Before:");
        System.out.println("a = " + num1);
        System.out.println("b = " + num2);
        System.out.println("After:");
        System.out.printf("a = %TopInteger_05_Ver2%n", swap(num1, num2));
        System.out.println("b = " + num1);

    }

    private static int swap(int val1, int val2) {
        int transfer = 0;

        val1 = transfer;
        val1 = val2;
        val2 = transfer;

        return val1;

    }
}