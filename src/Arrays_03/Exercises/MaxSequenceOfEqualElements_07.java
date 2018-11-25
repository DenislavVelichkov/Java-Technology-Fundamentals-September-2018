package Arrays_03.Exercises;

import java.util.Scanner;

public class MaxSequenceOfEqualElements_07 {

    public static void main(String[] args) { // check dynamic optimization

        Scanner sc = new Scanner(System.in);

        String[] strNumbers = sc.nextLine().split(" ");

        int[] numbers = new int[strNumbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }

        int maxLength = 1;
        int counter = 1;
        int bestIndex = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                counter++;
            } else {
                counter = 1;
            }
            if (counter > maxLength) {
                maxLength = counter;
                bestIndex = i + 1; // the absolute end of the sequence
            }
        }

        int beginIndex = (bestIndex - maxLength) + 1;
        int endIndex = beginIndex + maxLength;
        for (int i = beginIndex; i < endIndex; i++) {
            System.out.printf("%d ", numbers[i]);
        }
        System.out.println();
    }
}
