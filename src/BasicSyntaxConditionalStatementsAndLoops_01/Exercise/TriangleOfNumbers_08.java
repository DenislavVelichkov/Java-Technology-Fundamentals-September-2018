package BasicSyntaxConditionalStatementsAndLoops_01.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleOfNumbers_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }
}
