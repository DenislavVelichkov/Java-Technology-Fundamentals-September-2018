package _05_Lists.Exercises;

import java.util.*;

public class AppendArrays_07 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] str = scan.nextLine().split("\\|");

        ArrayList<String> strReversed = new ArrayList<>();


        for (int i = str.length - 1; i >= 0; i--) {
            String[] string = str[i].split("\\s+");
            strReversed.addAll(Arrays.asList(string));

        }
        strReversed.removeIf(String::isEmpty);

        for (int i = 0; i < strReversed.size(); i++) {
            if (strReversed.get(i).equals("")) {
                strReversed.remove(i);
                i--;
            }

        }
        strReversed.forEach(e -> System.out.print(e + " "));

    }
}
