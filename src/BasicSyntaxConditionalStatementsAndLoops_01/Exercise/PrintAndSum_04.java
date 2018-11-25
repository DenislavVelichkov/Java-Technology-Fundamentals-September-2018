package BasicSyntaxConditionalStatementsAndLoops_01.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintAndSum_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int startNum = Integer.parseInt(reader.readLine());
        int endNum = Integer.parseInt(reader.readLine());

        int sum = 0;

        for (int i = startNum; i <= endNum; i++) {
            sum += i;
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.println("Sum: " + sum);
    }
}
