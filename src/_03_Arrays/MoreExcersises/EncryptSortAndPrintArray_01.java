package Arrays_03.MoreExcersises;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray_01 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int sequenceCount = Integer.parseInt(scan.nextLine());
        int[] finalResult = new int[sequenceCount];

        for (int i = 0; i < sequenceCount; i++) {
            char[] strSequence = scan.nextLine().toCharArray();

            int encryptionValue = encrypt(strSequence);
            finalResult[i] = encryptionValue;
        }

        Arrays.sort(finalResult);
        for (int i = 0; i < finalResult.length; i++) {
            System.out.println(finalResult[i]);
        }
    }

    private static Integer encrypt(char[] str) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        int sum = 0;
        boolean isVowel = false;

        for (int i = 0; i < str.length; i++) {
            isVowel = false;
            for (int j = 0; j < vowels.length; j++) {
                if (str[i] == (vowels[j])) {
                    sum += vowels[j] * str.length;
                    isVowel = true;
                }
            }

            if (!isVowel) {
                sum += str[i] / str.length;
            }

        }
        return sum;
    }
}
