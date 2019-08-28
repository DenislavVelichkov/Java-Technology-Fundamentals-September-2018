package Arrays_03.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonElements_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] textOne = reader.readLine().split(" ");
        String[] textTwo = reader.readLine().split(" ");

        for (int i = 0; i < textTwo.length; i++) {
            for (int j = 0; j < textOne.length; j++) {
                if (textTwo[i].equals(textOne[j])) {
                    System.out.print(textTwo[i]);
                    break; // Ще намали броя на интерациите, може и без него.
                }
            }
        }
    }
}

/*
 * we can use regex:"\\s+" when we
 * have to use one (1) or more spaces
 * функцията на regex е където срещне "символа", да разделя на String
 * "symbol+" така разделя по String, когато срещне един или повече символа
*/