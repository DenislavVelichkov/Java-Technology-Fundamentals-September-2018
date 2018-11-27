package StringAndTextProcessing_09.MoreExercises;

import java.util.Scanner;

public class ExtractPersonInformation_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String line = sc.nextLine();

            String[] text = line.split("");

            int indexBorderNameA = line.indexOf("@");
            int indexBorderNameB = line.indexOf("|");
            int indexBorderAgeA = line.indexOf("#");
            int indexBorderAgeB = line.indexOf("*");
            String name = line.substring(indexBorderNameA + 1, indexBorderNameB);
            String age = line.substring(indexBorderAgeA + 1, indexBorderAgeB);
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
