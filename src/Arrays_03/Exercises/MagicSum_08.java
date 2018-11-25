package Arrays_03.Exercises;

import java.util.Scanner;

public class MagicSum_08 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strNumbers = sc.nextLine().split(" ");

        int[] numbers = new int[strNumbers.length];
        int input = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == input) {
                    System.out.printf("%d %d%n", numbers[i], numbers[j]);
                }
            }
        }
    }
}