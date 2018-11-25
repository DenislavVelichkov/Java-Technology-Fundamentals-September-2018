package BasicSyntaxConditionalStatementsAndLoops_01.Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbersInRange_13_Lab { //BigInteger for loop
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger first = new BigInteger(sc.nextLine());
        BigInteger second = new BigInteger(sc.nextLine());

        BigInteger sum = BigInteger.valueOf(0);

        for (BigInteger i = first; i.compareTo(second) <= 0; i = i.add(BigInteger.valueOf(1))) {
            sum = sum.add(i);
        }
        System.out.println(sum);
    }
}


