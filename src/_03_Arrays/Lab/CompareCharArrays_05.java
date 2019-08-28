package Arrays_03.Lab;

import java.util.Scanner;

public class CompareCharArrays_05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String firstText = sc.nextLine();
        String[] firstTextArray = firstText.split(" ");
        char[] first = new char[firstTextArray.length];

        for (int i = 0; i < firstTextArray.length; i++) {
            first[i] = firstTextArray[i].charAt(0);
        }

        String[] secondText = sc.nextLine().split(" ");
        char[] second = new char[secondText.length];

        for (int i = 0; i < secondText.length; i++) {
            second[i] = secondText[i].charAt(0);

        }

        int smallestLength = Math.min(first.length, second.length);

        char[] smallest = first.length <= second.length ? first : second;
        char[] biggest = first.length > second.length ? first : second;

        for (int i = 0; i < smallestLength; i++) {
            if (first[i] < second[i]) {
                break;
            }
            if (second[i] < first[i]) {
                smallest = second;
                first = biggest;
                break;
            }
        }
        System.out.println();

    }
}
