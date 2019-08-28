package _06_Bitwise_Operations.Lab;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class BinaryDigitsCount_01 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());

        var binary = Integer.toBinaryString(n).split("");
        int count = 0;

        for (int i = 0; i < binary.length; i++) {

            if (Integer.parseInt(binary[i]) ==  b) {
                count++;
            }
        }

        System.out.println(count);
    }
}

