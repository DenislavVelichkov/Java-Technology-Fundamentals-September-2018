package _05_Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics_04 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        while (true) {
            String command = scan.nextLine().toLowerCase();

            if (command.equals("end")) {
                break;
            }

            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "add":
                    int numberToAdd = Integer.parseInt(tokens[1]);
                    numbers.add(numberToAdd);
                    break;
                case "remove":
                    int numberToRemove = Integer.parseInt(tokens[1]);
                    numbers.remove(Integer.valueOf(numberToRemove));
                    // If you want to remove number as object, use Integer.valueOf();
                    break;
                case "removeat":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    numbers.remove(indexToRemove);
                    break;
                case "insert":
                    int numberToInsert = Integer.parseInt(tokens[1]);
                    int indexToInsert = Integer.parseInt(tokens[2]);
                    numbers.add(indexToInsert, numberToInsert);
                    break;
                    default:
                        break;
            }
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}