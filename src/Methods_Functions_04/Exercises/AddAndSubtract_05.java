package Methods_Functions_04.Exercises;

import java.util.Scanner;

public class AddAndSubtract_05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int int1 = Integer.parseInt(sc.nextLine());
        int int2 = Integer.parseInt(sc.nextLine());
        int int3 = Integer.parseInt(sc.nextLine());

        System.out.println(subtract(int3, sumMethod(int1, int2)) );

    }

    private static Integer sumMethod(int x, int y) {
        int sum = x + y;
        return sum;
    }

    private static Integer subtract(int n, int subtractor) {
        int result = subtractor - n;
        return result;
    }
}
