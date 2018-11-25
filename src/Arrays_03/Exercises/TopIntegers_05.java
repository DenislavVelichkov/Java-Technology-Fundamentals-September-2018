package Arrays_03.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TopIntegers_05 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            long[] array = Arrays.stream(reader.readLine().split(" ")).mapToLong(e -> Long.parseLong(e)).toArray();


            String str = "";

            for (int i = 0; i < array.length; i++) {  // for each се достъпва с "iter"
                if (topInteger(array, i)) {
                    System.out.print(array[i] + " ");
                }
            }

            System.out.println(str);
        } catch (NumberFormatException e) {
        }
    }

    private static Boolean topInteger(long[] array, int element) {  //compare element from array to his right elements
        boolean isBigInt = false;
        int counter = 0;

        long numToCompare = array[element];


        for (int i = element; i < array.length; i++) {
            if (numToCompare >= array[i]) {
                isBigInt = true;
            } else {
                isBigInt = false;
                counter++;
            }
        }
        return counter == 0 ? isBigInt : false;
    }
}
