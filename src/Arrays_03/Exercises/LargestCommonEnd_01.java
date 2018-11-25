package Arrays_03.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestCommonEnd_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] text1 = reader.readLine().split(" ");
        String[] text2 = reader.readLine().split(" ");


    }

    private static String reverseStr(String str) { //Reading String backwards
        int i, length = str.length();

        StringBuilder reverseStr = new StringBuilder(length);

        for (i = (length - 1); i >= 0; i--) {
            reverseStr.append(str.charAt(i));
        }

        return reverseStr.toString();
    }
}