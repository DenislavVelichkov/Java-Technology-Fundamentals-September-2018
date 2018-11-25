package AssociativeArrays_07.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter_04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] words = Arrays.stream(sc.nextLine().split(" ")).filter(w -> w.length() % 2 == 0)
                .toArray(String[]::new);

        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s%n", words[i]);
        }
    }
}
