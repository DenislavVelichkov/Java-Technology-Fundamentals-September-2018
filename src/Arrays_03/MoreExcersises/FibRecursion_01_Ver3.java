package Arrays_03.MoreExcersises;


import java.util.Scanner;

public class FibRecursion_01_Ver3 {


    private static Scanner scan = new Scanner(System.in);

    private static int n = Integer.parseInt(scan.nextLine());

    private static long[] fibonaccies = new long[n + 1];

    public static void main(String[] args) {

        long fib8 = fibonacci(n);
        System.out.println(fib8);
    }

    private static long fibonacci(int n) {

        if (n == 2 || n == 1)
            return 1;

        if (fibonaccies[n] != 0) {
            return fibonaccies[n];
        }

        long prev = fibonacci(n - 1);
        long prevPrev = fibonacci(n - 2);

        long result = prev + prevPrev;
        fibonaccies[n] = result;

        return result;
    }
}