package _05_Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_02 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split("\\s+");

            if (tokens[0].equals("Delete")) {
                removeAll(numbers, tokens[1]);
            }

            if (tokens[0].equals("Insert")) {
                int index = Integer.parseInt(tokens[2]);
                int element = Integer.parseInt(tokens[1]);

                if (index < numbers.size()) {
                    numbers.add(index, element);
                }
            }

            command = scan.nextLine();
        }

        for (Integer num : numbers) {
            System.out.printf("%d ", num);
        }

    }

    private static void removeAll(List<Integer> numbers, String s) {
        int index = Integer.parseInt(s);

        while (numbers.contains(index)) {
            numbers.remove(Integer.valueOf(index));
        }

//        return numbers;
    }

}
