package _02_Data_Types_And_Variables.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LowerToUpper_07 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String letter = reader.readLine();

        if (!letter.equals(letter.toLowerCase())) {//Check if a letter is a lower or upper case
            System.out.println("upper-case");

        } else {
            System.out.println("lower-case");

        }
    }
}
