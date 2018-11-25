package Methods_Functions_04.Exercises;

import java.util.Scanner;

public class FactorialDivision_08 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());

        System.out.printf("%.2f",  factorial(a) / factorial(b));
    }

    private static Double factorial(int x) {
        double num = 1;

        do {
            num *= x;
            x--;
        } while (x > 0);
        return num;

    }
}
