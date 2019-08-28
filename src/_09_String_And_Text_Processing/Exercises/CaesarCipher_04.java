package _09_String_And_Text_Processing.Exercises;

import java.util.Scanner;

public class CaesarCipher_04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char symbol = (char) (input.charAt(i) + 3);
            System.out.print(symbol);
        }
        System.out.println();
    }
}
