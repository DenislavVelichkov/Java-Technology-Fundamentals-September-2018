package Lists_05.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGames_06 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> handA = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> handB = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int i = 0;
        while (true) {
            if (handA.isEmpty() || handB.isEmpty()) {
                break;
            }

            i++;
            if (handA.get(i) > handB.get(i)) {
                handA.add(handA.get(i));
                handA.add(handB.get(i));
                handA.remove(handA.get(i));
                handB.remove(handB.get(i));
            } else if (handA.get(i) < handB.get(i)) {
                handB.add(handB.get(i));
                handB.add(handA.get(i));
                handB.remove(handB.get(i));
                handA.remove(handA.get(i));
            } else {
                handA.remove(handA.get(i));
                handB.remove(handB.get(i));
            }

            i = -1;
        }

        if (handA.size() > handB.size()) {
            System.out.print("First player wins!");
            int sum = 0;

            for (Integer index : handA) {
                sum += index;
            }

            System.out.printf(" Sum: %d", sum);

        } else if (handA.size() < handB.size()) {
            System.out.print("Second player wins!");
            int sum = 0;

            for (Integer index : handB) {
                sum += index;
            }

            System.out.printf(" Sum: %d", sum);
        }
    }
}


