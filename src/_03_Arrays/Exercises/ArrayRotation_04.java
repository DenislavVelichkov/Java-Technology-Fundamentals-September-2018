package _03_Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation_04 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

      int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
      int rotations = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < rotations; i++) {
            swapArray(array);
        }

        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void swapArray(int[] arr) {
        int swap = arr[0];

        for (int i = 0; i < arr.length; i++) {
            try {
                arr[i] = arr[i + 1];
            }catch (ArrayIndexOutOfBoundsException e){
                arr[arr.length - 1] = swap;
            }
        }
    }
}
