package _02_Data_Types_And_Variables.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumDigits_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());
        int sum = 0;

        while (num != 0) { //Split Integer to digits

            sum += num % 10;

            num /= 10;

        }
        System.out.println(sum);

    }
}
