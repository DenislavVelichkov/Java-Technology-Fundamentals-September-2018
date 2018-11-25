package DataTypesAndVariables_02.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharsToString_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char letter1 = reader.readLine().charAt(0);
        char letter2 = reader.readLine().charAt(0);
        char letter3 = reader.readLine().charAt(0);

        String finalString = "" + letter1 + letter2 + letter3;
        System.out.println(finalString);
    }
}
