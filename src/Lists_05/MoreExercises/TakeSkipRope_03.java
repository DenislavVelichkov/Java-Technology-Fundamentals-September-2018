package Lists_05.MoreExercises;

import java.util.*;
import java.util.stream.Collectors;

public class TakeSkipRope_03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> massage = Arrays.stream(sc.nextLine().split("")).collect(Collectors.toList());
        List<String> numSeq = new ArrayList<>();
        List<String> skipList = new ArrayList<>();
        List<String> takeList = new ArrayList<>();


        for (int i = 0; i < massage.size(); i++) {
            if (Character.isDigit(massage.get(i).charAt(0))) {  // How to check if a character in a list is digit
                numSeq.add((massage.get(i)));
            }
        }

        massage.removeAll(numSeq);
        for (int i = 0; i < numSeq.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numSeq.get(i));
            } else {
                skipList.add(numSeq.get(i));
            }
        }

        for (int i = 0; i < skipList.size(); i++) {

        }
    }
}
