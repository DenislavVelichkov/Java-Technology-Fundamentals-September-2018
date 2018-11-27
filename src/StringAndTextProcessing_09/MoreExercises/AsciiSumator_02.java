package StringAndTextProcessing_09.MoreExercises;

import java.util.Scanner;

public class AsciiSumator_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char charA = sc.nextLine().charAt(0);
        char charB = sc.nextLine().charAt(0);
        String text = sc.nextLine();

        int sum = checkText(charA, text, charB);
        System.out.println(sum);


    }

    private static int checkText(int charA, String text, int charB) {
        int sum = 0;

        for (int j = 0; j < text.length(); j++) {
            if (text.charAt(j) > Math.min(charA, charB) &&
                    text.charAt(j) < Math.max(charA, charB)) {
                sum += text.charAt(j);
            }
        }

        return sum;
    }
}