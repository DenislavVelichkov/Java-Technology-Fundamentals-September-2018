package Lists_05.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BoomNumbers_05 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] tokens = scanner.nextLine().split(" ");

        int bomb = Integer.parseInt(tokens[0]);
        int power = Integer.parseInt(tokens[1]);

        while (numbers.contains(bomb)) {
            int index = numbers.indexOf(bomb); // find the bomb
            int begin = index - power;
            begin = Math.max(0, begin);

            for (int i = begin; i < index; i++) {
                numbers.remove(begin);
            }

            index = numbers.indexOf(bomb);
            int end = Math.min(index + power, numbers.size() - 1);
            for (int i = index; i <= end ; i++) {
                numbers.remove(index);

            }
        }

        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);

        }
        System.out.println(sum);
    }
}
// променяме стойностите на ел., които гърмят, за да не вадим елементи от масива, защото така се прецаква индексатора i}
