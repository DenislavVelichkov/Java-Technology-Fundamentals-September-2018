package Arrays_03.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays_03 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int[] array1 = new int[n];
        int[] array2 = new int[n];
        int counter = 0;

        for (int i = 0; i < n; i++) {
            int[] array = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e)).toArray();
            for (int j = 0; j < array.length - 1; j++) {
                array1[i] = array[j];
                array2[i] = array[j + 1];
            }
        }

        for (int i = 1; i <= n - 1; i++) {
            int swap = 0;
            if (i % 2 != 0) {
                swap = array1[i];
                array1[i] = array2[i];
                array2[i] = swap;
            }
        }

        print(array1);
        System.out.println();
        print(array2);
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}