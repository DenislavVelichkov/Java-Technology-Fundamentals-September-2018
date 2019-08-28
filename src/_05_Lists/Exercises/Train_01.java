package _05_Lists.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Train_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> wagons = Arrays
                .stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int wagonCapacity = Integer.parseInt(reader.readLine());
        String[] line = reader.readLine().split(" ");

        while (!line[0].equals("end")) {

            if (line[0].equals("Add")) {
                wagons.add(Integer.parseInt(line[1]));
            } else {
                int temp = Integer.parseInt(line[0]);

                for (int i = 0; i < wagons.size(); i++) {
                    if (wagonCapacity >= wagons.get(i) + temp) {
                        wagons.set(i, wagons.get(i) + temp);
                        break;
                    }
                }
            }

            line = reader.readLine().split(" ");
        }

        for (int i = 0; i < wagons.size(); i++) {
            System.out.printf("%d ", wagons.get(i));
        }

    }
}