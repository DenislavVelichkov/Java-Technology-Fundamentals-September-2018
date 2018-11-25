package StringAndTextProcessing_09.Lab;

import java.util.Scanner;

public class Substring_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String toRemove = sc.nextLine();
        String text= sc.nextLine();

        while (text.contains(toRemove)) {
           text = text.replace(toRemove, "");
        }
        System.out.println(text);
    }
}
