package Arrays_03.Exercises;

import java.util.Scanner;

public class ArrayRotation_04_Ver2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] strNumbers = scan.nextLine().split(" ");
        int rotations = Integer.parseInt(scan.nextLine());

        rotations = rotations % strNumbers.length;

        for (int i = 0; i < rotations; i++) {
            String element = strNumbers[0];
            for (int j = 0; j < strNumbers.length -1; j++) {
                strNumbers[i] = strNumbers[i + 1];

            }

            strNumbers[strNumbers.length - 1] = element;
        }

        for (String str : strNumbers) {
            System.out.print(str + " ");
        }
    }
}
