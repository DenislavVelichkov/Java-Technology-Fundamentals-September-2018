package _05_Lists.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumAdjacentEqual_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Double> numbers = Arrays.stream(reader.readLine().split(" "))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            try {
                if (numbers.get(i).equals(numbers.get(i + 1))) {
                    numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                    numbers.remove(i + 1);
                    i = -1;
                }
            } catch (Exception e) {
                break;
            }

        }
        String output = joinElementsByDelimiter(numbers, " ");
        System.out.println(output);
    }

    private static String joinElementsByDelimiter(List<Double> numbers, String s) {
        String output = "";

        for (Double item : numbers) {
            output += new DecimalFormat("0.#").format(item)
                        + s;
        }

        return output;
    }
}
