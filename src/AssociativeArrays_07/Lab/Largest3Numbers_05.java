package AssociativeArrays_07.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers_05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List nums = new ArrayList();

        List<Integer> sorted = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        int count = 0;
        for (int i = 0; i < sorted.size(); i++) {
            count++;

            nums.add(sorted.get(i));
            if (count == 3) {
                break;
            }
        }

        for (int i = 0; i < nums.size(); i++) {
            System.out.printf("%d ", nums.get(i));
        }
    }
}

