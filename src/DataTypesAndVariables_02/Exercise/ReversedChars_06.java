package DataTypesAndVariables_02.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReversedChars_06 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char symbol1 = reader.readLine().charAt(0);
        char symbol2 = reader.readLine().charAt(0);
        char symbol3 = reader.readLine().charAt(0);

        System.out.printf("%s %s %s",symbol3, symbol2, symbol1);
    }
}
