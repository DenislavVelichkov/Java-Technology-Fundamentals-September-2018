package ArraysDemo_03.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CondencseArrayToNumber_07 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] arrayNum = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] condensed;
        int condensedSum = 0;
        int storeSingleValue = 0;

        do {
            condensed = new int[arrayNum.length - 1];
            try {
                for (int i = 0; i < arrayNum.length - 1; i++) {
                    condensed[i] = arrayNum[i] + arrayNum[i + 1];
                }
            } catch (Exception e) { }

            storeSingleValue = arrayNum[0];
            arrayNum = condensed;

        } while (!(arrayNum.length - 1 < 2));
        try {
            System.out.printf("%TopInteger_05_Ver2", condensedSum = condensed[0] + condensed[1]);
            } catch (Exception e) {
                    System.out.printf("%TopInteger_05_Ver2", condensedSum = storeSingleValue);
        }
    }
}
