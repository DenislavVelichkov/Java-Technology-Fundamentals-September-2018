package _06_Bitwise_Operations.Lab;

import java.util.Scanner;

public class OddTimes_05 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] array = scan.nextLine().split(" ");

        int[] numArray = new int[array.length];

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = Integer.parseInt(array[i]);
        }

        int result = 0;
        for (int i = 0; i < numArray.length; i++) {
            result = result ^ numArray[i];
        }

        System.out.println(result);
    }
}
