package Arrays_03.Exercises;

import java.util.Scanner;

public class ZigZagArrays_03_Ver2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int linesCount = Integer.parseInt(scan.nextLine());

        int[] first = new int[linesCount];
        int[] second = new int[linesCount];

        for (int i = 0; i < linesCount; i++) {
            String[] numbers = scan.nextLine().split(" ");
            if (i % 2 == 0) {
                first[i] = Integer.parseInt(numbers[0]);
                second[i] = Integer.parseInt(numbers[1]);
            } else {
                first[i] = Integer.parseInt(numbers[1]);
                second[i] = Integer.parseInt(numbers[0]);
            }
        }

        for (int number : first) {
            System.out.print(number + " ");
        }

        System.out.println();

        for (int number : second) {
            System.out.print(number + " ");
        }

    }
}
