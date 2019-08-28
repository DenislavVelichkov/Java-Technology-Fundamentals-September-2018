package _04_Methods_Functions.Exercises;

import java.util.Scanner;

public class VowelsCount_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] word = sc.nextLine().toCharArray();

        System.out.println(findVowelsCount(word));
    }

    private static Integer findVowelsCount(char[] str) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        boolean isVowel;
        int counter = 0;

        for (int i = 0; i < str.length; i++) {
            isVowel = false;
            for (int j = 0; j < vowels.length; j++) {
                if (str[i] == (vowels[j])) {
                    isVowel = true;
                    counter++;
                }
            }
        }
        return counter;
    }
}
