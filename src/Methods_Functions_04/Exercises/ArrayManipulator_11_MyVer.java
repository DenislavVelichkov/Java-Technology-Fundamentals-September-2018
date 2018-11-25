package Methods_Functions_04.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayManipulator_11_MyVer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine()
                .split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = sc.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");

            if (tokens[0].equals("Exchange")) {
                int index = Integer.parseInt(tokens[1]);

                if (index < 0 || index > numbers.size()) {
                    System.out.println("Invalid index");
                    break;
                } else {
                    exchange(numbers, index);
                }
            }

            if (tokens[0].equals("max")) {
                findMaxIndex(numbers, tokens[1]);
            }

            if (tokens[0].equals("min")) {
                findMinIndex(numbers, tokens[1]);
            }

            command = sc.nextLine();
        }
    }

    private static void findMinIndex(List<Integer> numbers, String token) {
    }

    private static int findMaxIndex(List<Integer> numbers, String token) {
        int maxEvenIndex = -1;
        int maxOddIndex = -1;
        int maxEvenValue = Integer.MIN_VALUE;
        int maxOddValue = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.size(); i++) {
            int currentValue = numbers.get(i);

            if (currentValue % 2 == 0 && currentValue >= maxEvenValue) {
                maxEvenValue = currentValue;
                maxEvenIndex = i;
            } else if (currentValue % 2 != 0 && currentValue >= maxOddValue) {
                maxOddValue = currentValue;
                maxOddIndex = i;
            }
        }

        if (token.equals("even")) {
            return maxEvenIndex;
        } else {
            return maxOddIndex;
        }
    }

    private static List<Integer> exchange(List<Integer> numbers, int index) {
        List<Integer> changed = new ArrayList<>();
        int j = 0;

        for (int i = index + 1; i < numbers.size(); i++) {
            changed.add(j, numbers.get(Integer.valueOf(i)));
            j++;
        }

        for (int i = 0; i <= index; i++) {
            changed.add(j, numbers.get(i));
            j++;
        }

        numbers = changed;
        return numbers;
    }
}
