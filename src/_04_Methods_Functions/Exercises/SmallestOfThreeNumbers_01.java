package _04_Methods_Functions.Exercises;

import java.util.Scanner;

public class SmallestOfThreeNumbers_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[3];
        numbers[0] = Integer.parseInt(sc.nextLine());
        numbers[1] = Integer.parseInt(sc.nextLine());
        numbers[2] = Integer.parseInt(sc.nextLine());
        System.out.println(findMin(numbers));
    }

    private static Integer findMin(int[] array) {  //smallest number in array
        int findMinValue = array[0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                if ((array[i] < array[j]) && (findMinValue > array[i])) {
                    findMinValue = array[i];
                }

            }
        }

        return findMinValue;
    }
}
