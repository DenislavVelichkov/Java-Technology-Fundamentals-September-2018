package StringAndTextProcessing_09.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RageQuite_06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine().toUpperCase();

        System.out.printf("Unique symbols used: %d%n", checkUniqueSymbols(line));
        printText(line);
    }

    private static void printText(String line) {
        for (int i = 0; i < line.length(); i++) {
                int repeat = 0;
                String strToRepeat = "";
                String sequenceToRemove = "";

            if (Character.isDigit(line.charAt(i))) {
                repeat = Integer.parseInt(String.valueOf(line.charAt(i)));
                strToRepeat = line.substring(0, i);

                while (repeat-- > 0) {
                    System.out.printf("%s", strToRepeat);
                }

                sequenceToRemove = strToRepeat + line.charAt(i);
                line = line.replace(sequenceToRemove, "");
                i = 0;
            }
        }
    }

    private static int checkUniqueSymbols(String line) {
        int count = line.length();
        List<String> symbols = Arrays.asList(line.split(""));

        for (int i = 0; i < symbols.size(); i++) {
            if ((symbols.contains(symbols.get(i))) && (!Character.isDigit(symbols.get(i).charAt(0)))) {
                count -= 1;
            }
        }

        return count;
    }
}
