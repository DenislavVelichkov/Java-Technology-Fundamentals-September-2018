package BasicSyntaxConditionalStatementsAndLoops_01.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Student_Information_01_Lab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        double grade = Double.parseDouble(reader.readLine());

        System.out.printf("Name: %s, Age: %TopInteger_05_Ver2, Grade: %.2f", name, age, grade);
    }
}
