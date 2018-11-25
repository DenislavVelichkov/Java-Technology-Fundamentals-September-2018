package Arrays_03.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumEvenNumbers_03 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numArray = Arrays.stream(reader.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int sum = 0;

        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] % 2 == 0) {
                sum += numArray[i];
            }
        }

        System.out.printf("%TopInteger_05_Ver2", sum);
    }
}
