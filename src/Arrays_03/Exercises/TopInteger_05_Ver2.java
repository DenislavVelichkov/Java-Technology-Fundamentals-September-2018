package Arrays_03.Exercises;

import java.util.Scanner;

public class TopInteger_05_Ver2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] numbers = sc.nextLine().split("\\s+");
        long[] array = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            array[i] = Long.parseLong(numbers[i]);
        }

        for (int i = 0; i < array.length; i++) {
            boolean isBigInt = true;

            for (int j = i + 1; j < array.length; j++) {

                if (array[i] <= array[j])
                        isBigInt = false;

            }

            if (isBigInt) System.out.printf("%d ", array[i]);
        }
    }
}
