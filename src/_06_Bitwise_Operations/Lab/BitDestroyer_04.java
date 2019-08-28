package _06_Bitwise_Operations.Lab;

import java.util.Scanner;

public class BitDestroyer_04 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Please Enter N:");
        String input = scan.nextLine();
        System.out.println("Please Enter B:");
        String input2 = scan.nextLine();

        int num1 = Integer.parseInt(input);
        int num2 = Integer.parseInt(input2);

        int mask = ~(1 << num2); // създаване на маска, за да оперираме върху битовете
        int result = num1 & mask;

        System.out.println(result);
    }
}
