package Arrays_03.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseAnArrayOfStrings_04Ver2 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().split(" ");

        for (int i = 0; i < elements.length / 2; i++){ //reverse array elements in the actual array
            String oldElement = elements[i];
            elements[i] = elements[elements.length - 1 - i];
            elements[elements.length - 1 - i] = oldElement;
        }

        System.out.println(String.join(" ", elements));
    }
}
