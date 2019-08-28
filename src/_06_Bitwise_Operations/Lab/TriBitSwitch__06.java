package _06_Bitwise_Operations.Lab;

import java.util.Scanner;

public class TriBitSwitch__06 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number");
        int input = Integer.parseInt(scan.nextLine());
        System.out.println("Enter position");
        int inputPosition = Integer.parseInt(scan.nextLine());

        int mask = 7 << inputPosition;
        int result = input ^ mask;

        System.out.println(result);
    }
}
