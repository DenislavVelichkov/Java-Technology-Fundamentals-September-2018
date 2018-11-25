package Methods_Functions_04.Lab;

import java.util.Scanner;

public class SignOfInteger_01 {


    static void checkSign(int num) {

        if (num > 0) {
            System.out.printf("The number %d is positive", num);
        } else if (num == 0) {
            System.out.printf("The number %d is zero", num);

        } else {
            System.out.printf("The number %d is negative", num);

        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int nums = Integer.parseInt(scan.nextLine());

        checkSign(nums);

    }
}
