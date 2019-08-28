package _05_Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GausTrick_02_Ver2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size() / 2; i++) {
            numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
       /* String output = joinElementsByDelimiter(numbers, " ");
        System.out.println(output);*/
    }
    /*private static String joinElementsByDelimiter(List<Integer> numbers, String s) {
        String output = "";

        for (Integer item : numbers) {
            output += new DecimalFormat("0.#").format(item)
                    + s;
        }

        return output;
    }*/
}
