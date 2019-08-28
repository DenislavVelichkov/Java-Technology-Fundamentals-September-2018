package _08_Objects_And_Classes.Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        BigInteger n = BigInteger.valueOf(Long.parseLong(sc.nextLine()));
        BigInteger firstNumber = new BigInteger(sc.nextLine());
        BigInteger secondNumber = new BigInteger(sc.nextLine());

        BigInteger sum = firstNumber.add(secondNumber);

        System.out.println(sum);
    }
}
