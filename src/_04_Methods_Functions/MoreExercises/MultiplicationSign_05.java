package _04_Methods_Functions.MoreExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MultiplicationSign_05 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[3];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        if (checkForNull(numbers)) {
            System.out.println("zero");
        } else if (checkForPositive(numbers)) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }
    }

    private static boolean checkForPositive(int[] array) {
        ArrayList<Integer> temp = new ArrayList<>();
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] != 0) {
                temp.add(array[i]);
            } else {
                counter++;
            }
        }

        if (temp.size() == 3) {
            return true;
        }

        if (counter % 2 == 0) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean checkForNull(int[] array) {
        boolean isNull = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                isNull = true;
            }
        }

        return isNull;
    }
}
