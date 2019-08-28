package _02_Data_Types_And_Variables.Exercise.MoreExercises;

import java.math.BigInteger;
import java.util.Scanner;

public class DataTypeFinderVer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {  // Validating input data types in a loop
            String command = scanner.nextLine();

            if (command.equals("END")) {
                return;
            }

            try {
                BigInteger intType = new BigInteger(command);
                System.out.printf("%s is integer type\n", command);

            } catch (Exception e) {

            }

            try {
                double doubleType = Double.parseDouble(command);
                System.out.printf("%s is floating point type\n", command);

            } catch (Exception e) {

            }

            if (command.toLowerCase().equals("false") || command.toLowerCase().equals("true")) {
                System.out.printf("%s is boolean type\n", command);

            }

            if (command.length() == 1) {
                System.out.printf("%s is character type\n", command);
            } else if (command.length() > 1) {
                System.out.printf("%s is string type\n", command);
            }
        }
    }
}