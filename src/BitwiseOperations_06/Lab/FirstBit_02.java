package BitwiseOperations_06.Lab;

import java.util.Scanner;

public class FirstBit_02 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Please Enter N:");
        int input = Integer.parseInt(scan.nextLine());

        int shiftedNum = input >> 1;
        int result = shiftedNum & 1;

        System.out.println(result);
    }
}
