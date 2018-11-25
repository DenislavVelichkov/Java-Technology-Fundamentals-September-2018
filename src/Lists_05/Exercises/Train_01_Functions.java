package Lists_05.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Train_01_Functions {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int maxCapacity = Integer.parseInt(sc.nextLine());

        List<Integer> wagons = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line = sc.nextLine();

        while (!line.equals("end")) {
            String[] tokens = line.split(" ");

            if (tokens[0].equals("Add")) {
                int newWagon = Integer.parseInt(tokens[1]);
                wagons.add(newWagon);
            } else {
                int passengers = Integer.parseInt(tokens[1]);
                wagons.stream().filter(w -> maxCapacity - w >= passengers)
                        .findFirst()
                        .ifPresent(freeWagon -> {
                int indexOfFreeWagons = wagons.indexOf(freeWagon);
                wagons.set(indexOfFreeWagons, freeWagon + passengers);
                        });
            }

            line = sc.nextLine();
        }
    }
}
