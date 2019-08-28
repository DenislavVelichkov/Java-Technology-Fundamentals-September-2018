package _04_Methods_Functions.MoreExercises;

import java.util.Scanner;

public class CenterPoint_02 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        float x1 = Float.parseFloat(scan.nextLine());
        float y1 = Float.parseFloat(scan.nextLine());
        float x2 = Float.parseFloat(scan.nextLine());
        float y2 = Float.parseFloat(scan.nextLine());

        if (Math.abs(x1)  + Math.abs(y1) >= Math.abs(x2) + Math.abs(y2)) {
            System.out.printf("(%.0f, %.0f)", x2, y2);
        } else {
            System.out.printf("(%.0f, %.0f)", x1, y1);
        }
    }
}
