package BasicSyntaxConditionalStatementsAndLoops_01.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Month_printer_05_Lab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; //Massive

        if (n > 12 || n < 1) {
            System.out.println("Error!");
        } else {
            System.out.println(month[n - 1]);
        }
    }
}
