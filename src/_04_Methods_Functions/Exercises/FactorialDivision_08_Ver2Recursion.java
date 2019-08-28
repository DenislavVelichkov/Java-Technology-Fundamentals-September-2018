package _04_Methods_Functions.Exercises;

import java.util.Scanner;

public class FactorialDivision_08_Ver2Recursion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double first = Integer.parseInt(sc.nextLine());
        double second = Integer.parseInt(sc.nextLine());

        double result = fact(first) / fact(second);

        System.out.printf("%.2f", result);
    }

    private static double fact(double n) {
        if (n < 1) {
            return 1;
        }

        return n = n * fact(n - 1);
    }
}
