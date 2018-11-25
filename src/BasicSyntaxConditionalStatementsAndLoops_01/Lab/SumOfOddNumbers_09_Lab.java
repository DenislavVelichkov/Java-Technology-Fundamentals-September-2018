package BasicSyntaxConditionalStatementsAndLoops_01.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfOddNumbers_09_Lab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int sum = 0;
        int counter = 0;
        for (int i = 1; ; i++) {
            if (i % 2 != 0) {

                System.out.println(i);
                counter++;
                sum += i;

                if (counter == n) {
                    break;
                }
            }
        }
        System.out.println("Sum: " + sum);
    }
}
