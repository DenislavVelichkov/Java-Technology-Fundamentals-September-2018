package _04_Methods_Functions.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TopNumber_10 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine()) + 1;
        int[] arrayOfNumbers = new int[number];

        for (int i = 0; i < number; i++) {
            arrayOfNumbers[i] = i;
        }

        ArrayList<Integer> finalResult = splitEachArrayIndex(arrayOfNumbers);

        for (Integer integer : finalResult) {
            System.out.printf("%d%n", integer);
        }

    }

    private static ArrayList<Integer> splitEachArrayIndex(int[] array) {
        ArrayList<Integer> splitedNumber = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            List<Integer> splicedNum = splitNumber(array[i]);

            for (int j = 0; j < splicedNum.size(); j++) {
                int digit = splicedNum.get(j);
                sum += digit;
            }

            if (sum % 8 == 0 && checkIfOdd(array[i])) {
                splitedNumber.add(array[i]);
            }

            sum = 0;
        }

        return splitedNumber;
    }

    private static boolean checkIfOdd(int index) {
        List<Integer> numParts = new ArrayList<>();

        while (index > 0) {
            int digit = index % 10;
            index = index / 10;
            numParts.add(digit);
        }

        for (Integer integer : numParts) {
            if (integer % 2 != 0)
                return true;
        }

        return false;
    }

    private static List<Integer> splitNumber(int index) {
        List<Integer> numParts = new ArrayList<>();
        int digit;

        while (index > 0) {
            digit = index % 10;
            index = index / 10;
            numParts.add(digit);
        }

        return numParts;
    }
}
