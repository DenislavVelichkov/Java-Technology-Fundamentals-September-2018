package _09_String_And_Text_Processing.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplyBigNumber_05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /*We can't use BigInteger*/

        String number = sc.nextLine();

        int multiplicator = Integer.parseInt(sc.nextLine());

        if (multiplicator == 0) {
            System.out.println(0);
        } else {
            int reminder = 0;
            List<Integer> result = new ArrayList<>();

            for (int i = number.length() - 1; i >= 0; i--) {
                /*Because if we open ASCII table and substract 53 - 48 () which is zero we have 3*/
                int currentResult = (number.charAt(i) - '0') * multiplicator;
                currentResult += reminder;
                reminder = currentResult / 10;
                result.add(currentResult % 10);
            }


            if (reminder != 0) {
                result.add(reminder);
            }

            for (int i = result.size() - 1; i >= 0; i--) {
                System.out.print(result.get(i));
            }

            System.out.println();

        }
    }
}

