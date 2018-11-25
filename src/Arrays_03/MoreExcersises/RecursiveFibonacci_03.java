package Arrays_03.MoreExcersises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFibonacci_03 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        long[] fibonaccies = new long[n + 1];
        fibonaccies[0] = 0;
        fibonaccies[1] = 1;

        System.out.printf("%d", fibonacci(n, fibonaccies));

    }

    private static long fibonacci(long num, long[] array) {
        long fib0 = 0L;
        long fib1 = 1L;
        long result = 0L;
        long prev = fibonacci(num - 1L, array);
        long prevPrev = fibonacci(num - 2L, array);

        for (int i = 1; i <= num - 1; i++) {
            long fn = fib0 + fib1;
            fib0 = fib1;
            fib1 = fn;
        }
        result = fib1;

        //if (array[] != result)

        return result = prev + prevPrev;
    }
}


