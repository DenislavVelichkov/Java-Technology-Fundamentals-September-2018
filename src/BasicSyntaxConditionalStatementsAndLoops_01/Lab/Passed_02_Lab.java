package BasicSyntaxConditionalStatementsAndLoops_01.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Passed_02_Lab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double grade = Double.parseDouble(reader.readLine());

        if (grade >= 3.00) {
            System.out.println("Passed!");
        }else {
            System.out.print("Failed!");
        }

    }
}
