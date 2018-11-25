package ObjectsAndClasses_08.Lab;

import java.util.Random;
import java.util.Scanner;





public class RandomizeWords_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split(" ");

        Random rnd = new Random();

        for (int pos1 = 0; pos1 < words.length - 1; pos1++) {
            int pos2 = rnd.nextInt(words.length);
            String temp = words[pos1];
            words[pos1] = words[pos2];
            words[pos2] = temp;
        }

        for (int i = 0; i < words.length; i++) {
            System.out.println(String.join("%n", words[i]));

        }

    }
}
