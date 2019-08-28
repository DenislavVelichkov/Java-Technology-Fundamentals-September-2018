package Arrays_03.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Train_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] train = new int[n];
        int sumOfPeople = 0;

        for (int i = 0; i < n; i++) {
            train[i] = Integer.parseInt(reader.readLine());
            System.out.printf("%TopInteger_05_Ver2 ", train[i]);
            sumOfPeople += train[i];
        }
        System.out.println();
        System.out.println(sumOfPeople);
    }
}
