package Arrays_03.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseAnArrayOfStrings_04 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrayOfStr = reader.readLine().split(" ");

        for (int i = arrayOfStr.length - 1; i >= 0; i--) {
            System.out.printf("%s ", arrayOfStr[i]);
        }

    }
}
