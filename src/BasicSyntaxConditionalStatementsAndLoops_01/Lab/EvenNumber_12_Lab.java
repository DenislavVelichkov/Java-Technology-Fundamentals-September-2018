package BasicSyntaxConditionalStatementsAndLoops_01.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenNumber_12_Lab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int evenNumber = Integer.parseInt(reader.readLine());

            if (evenNumber % 2 == 0) {
                System.out.println("The number is: " + Math.abs(evenNumber));
                return;
            } else {
                System.out.println("Please write an even number.");
            }
        }
    }
}
