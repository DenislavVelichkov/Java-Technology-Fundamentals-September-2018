package Lists_05.Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GausTrick_02 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
//        int counter = 0;

        for (int i = 0; i < numbers.size() - 1; i++) {
//            if (numbers.size() == 3) break;
            try {
                numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
                numbers.remove(numbers.size() - 1);
//                counter++;
//                i = -1;
            } catch (Exception e) {
                break;
            }

        }
        String output = joinElementsByDelimiter(numbers, " ");
        System.out.println(output);
    }

    private static String joinElementsByDelimiter(List<Integer> numbers, String s) {
        String output = "";

        for (Integer item : numbers) {
            output += new DecimalFormat("0.#").format(item)
                    + s;
        }

        return output;
    }
}
