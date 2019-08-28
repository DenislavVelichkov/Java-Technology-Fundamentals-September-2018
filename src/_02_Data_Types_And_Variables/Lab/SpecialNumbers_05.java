package _02_Data_Types_And_Variables.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialNumbers_05 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= num; i++) {
            int digitSum = 0;
            String currentNumber = "" + i;

            for (int j = 0; j < currentNumber.length(); j++) {
                digitSum += Integer.parseInt(currentNumber.charAt(j) + "");
            }

            boolean isFive = digitSum == 5;
            boolean isSeven = digitSum == 7;
            boolean isEleven = digitSum == 11;
            boolean isSpecial = isFive || isSeven || isEleven;

            String special = isSpecial + ""; // true with capital letter
            special = (special.charAt(0)+"").toUpperCase()
                    + special.substring(1);
            System.out.println(i + " -> " + special);

        }
    }
}
