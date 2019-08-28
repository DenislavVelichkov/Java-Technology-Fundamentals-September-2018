package _09_String_And_Text_Processing.MoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuite_06 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine().toUpperCase();

        List<String> temp = Arrays.asList(line.split("\\d+"));
        ArrayList<String> arrayToModify = new ArrayList<>(temp);

        Pattern digitPattern = Pattern.compile("\\d+");
        Matcher matcher = digitPattern.matcher(line);

        StringBuilder buffer = new StringBuilder();
        long sum;

        while (arrayToModify.size() > 0) {
            for (int i = 0; i < arrayToModify.size(); i++) {
                int repeat = 0;
                String strToRepeat = "";

                strToRepeat += arrayToModify.get(i);

                if (matcher.find()) {
                    repeat = Integer.parseInt(matcher.group());
                }

                while (repeat-- > 0) {
                    buffer.append(strToRepeat);
                }

                arrayToModify.remove(strToRepeat);
                i = -1;
            }
        }

        sum = buffer.chars().distinct().count();
        System.out.printf("Unique symbols used: %d%n", sum);
        System.out.print(buffer);
    }
}