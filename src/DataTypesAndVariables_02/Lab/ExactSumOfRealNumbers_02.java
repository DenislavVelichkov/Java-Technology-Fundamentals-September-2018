package DataTypesAndVariables_02.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class ExactSumOfRealNumbers_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        BigDecimal sum = new BigDecimal(0); //Using Big Decimal for large numbers, used in Finances

        for (int i = 0; i < n; i++) {
            BigDecimal num = new BigDecimal(reader.readLine());

            sum = sum.add(num);
        }
        System.out.println(sum);
    }
}
