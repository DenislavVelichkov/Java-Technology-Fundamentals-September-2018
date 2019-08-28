package Exam_Exercises.ProgFundAdditionalRetakeExam_28October2018Part2;

import java.util.Scanner;

public class ChoreWars_03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        int dishes = 0, cleaning = 0, laundry = 0;

        while (!line.equals("wife is happy")) {
            if (line.contains("{") && line.contains("}")) {
                int begin = line.indexOf("{") + 1;
                int end = line.indexOf("}");

                String data = line.substring(begin, end);

                for (int i = 0; i < data.length(); i++) {
                    if (Character.isDigit(data.charAt(i))) {
                        laundry += data.charAt(i) - '0';
                    }
                }
            } else if (line.contains("<") && line.contains(">")) {
                int begin = line.lastIndexOf("<") + 1;
                int end = line.indexOf(">");

                String data = line.substring(begin, end);

                if (isValidDishes(data)) {
                    for (int i = 0; i < data.length(); i++) {
                        if (Character.isDigit(data.charAt(i))) {
                            dishes += data.charAt(i) - '0';
                        }
                    }
                }
            } else if (line.contains("[") && line.contains("]")) {
                int begin = line.lastIndexOf("[") + 1;
                int end = line.indexOf("]");

                String data = line.substring(begin, end);

                if (isValidCleaning(data)) {
                    for (int i = 0; i < data.length(); i++) {
                        if (Character.isDigit(data.charAt(i))) {
                            dishes += data.charAt(i) - '0';
                        }
                    }
                }
            }

            line = sc.nextLine();
        }

        System.out.printf("Doing the dishes - %d min.", dishes);
        System.out.printf("Cleaning the house - %d min.", cleaning);
        System.out.printf("Doing the laundry - %d min.", laundry);
        System.out.printf("Total - %d min.", dishes + cleaning + laundry);

    }

    private static boolean isValidDishes (String data){
        for (int i = 0; i < data.length(); i++) {
            if (!Character.isLowerCase(data.charAt(i)) &&
                    !Character.isDigit(data.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    private static boolean isValidCleaning (String data){
        for (int i = 0; i < data.length(); i++) {
            if (!Character.isLowerCase(data.charAt(i)) &&
                    !Character.isDigit(data.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}