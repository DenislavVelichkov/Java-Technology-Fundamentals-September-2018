package Methods_Functions_04.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Grades_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grade = reader.readLine();
        float gradeInNumber = Float.parseFloat(grade);
        gradeInWords(gradeInNumber);
    }

    private static void gradeInWords(float grade) {

        if (grade >= 2.00 && grade <= 2.99) {
            System.out.print("Fail");
        } else if (grade <= 3.49) {
            System.out.print("Poor");
        } else if (grade <= 4.49) {
            System.out.print("Good");
        }else if (grade <= 5.49) {
            System.out.print("Very good");
        } else {
            System.out.print("Excellent");
        }
    }
}
