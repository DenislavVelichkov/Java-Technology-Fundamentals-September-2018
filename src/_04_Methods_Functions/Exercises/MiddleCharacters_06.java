package _04_Methods_Functions.Exercises;

import java.util.Scanner;

public class MiddleCharacters_06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] words = sc.nextLine().toCharArray();


            if (words.length % 2 == 0) {
                System.out.printf("%s%s", words[words.length / 2 - 1], words[words.length / 2]);
            } else {
                System.out.printf("%s", words[words.length / 2]);
            }



    }
}
