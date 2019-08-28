package _02_Data_Types_And_Variables.Exercise.MoreExercises;

import java.util.Scanner;

public class DataTypeFinder_01 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            String input = scan.nextLine();

            if (input.equals("END")) return;

            tryToParse(input);


            if (input.length() == 1) {
                System.out.printf("%s is character type%n", input);

            } else if (input.length() > 1) {
                System.out.printf("%s is string type%n", input);

            }


        }
    }

    private static String tryToParse(String obj) {
        boolean flag = false;

        if (flag == false) {
            try {
                int value = Integer.parseInt(obj);
                System.out.printf("%s is integer type%n", value);

            } catch (Exception e) {
                e.getMessage();
            }
            flag = true;
        }

        try {
            float value = Float.parseFloat(obj);
            System.out.printf("%s is floating point type%n", value);

        } catch (Exception e) {
        }

        if (obj.toLowerCase().equals("false") || obj.toLowerCase().equals("true")) {
            System.out.printf("%s is boolean type%n", obj);

        }
        return obj;
    }
}

