package Methods_Functions_04.Exercises;

        import java.util.Scanner;

public class CharactersInRange_03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] range = new char[2];
        range[0] = sc.nextLine().charAt(0);
        range[1] = sc.nextLine().charAt(0);
        char controlValue;

        if (range[0] < range[1]) {
            printRangeOfChars(range);
        }
        else {
            controlValue = range[1];
            range[1] = range[0];
            range[0] = controlValue;
            printRangeOfChars(range);
        }

    }

    private static void printRangeOfChars(char[] givenRange) {

        for (int i = givenRange[0] + 1; i <= givenRange[1] - 1; i++) {

            System.out.printf("%s ", (char) i);
        }
    }
}
