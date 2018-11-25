package Methods_Functions_04.MoreExercises;

import java.util.Scanner;

public class TribonacciSequence_04 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        long num = Long.parseLong(scan.nextLine());

        long[] array = new long[Math.toIntExact(num)];

        if (num == 2) {
            array[0] = 1;
            array[1] = 1;

        } else if (num == 1) {
                System.out.println("1");
                return;

        } else {
            array[0] = 1;
            array[1] = 1;
            array[2] = 2;

            for (int i = 3; i < array.length; i++) {
                array[i] = array[i - 1] + array[i - 2] + array[i - 3];
            }

        }

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }

    }
}
