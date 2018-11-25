package Methods_Functions_04.MoreExercises;

import java.util.Scanner;

public class LongerLine_03 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        long x1 = Long.parseLong(scan.nextLine());
        long y1 = Long.parseLong(scan.nextLine());
        long x2 = Long.parseLong(scan.nextLine());
        long y2 = Long.parseLong(scan.nextLine());
        long x3 = Long.parseLong(scan.nextLine());
        long y3 = Long.parseLong(scan.nextLine());
        long x4 = Long.parseLong(scan.nextLine());
        long y4 = Long.parseLong(scan.nextLine());

        double firstLine = calcLineLength(x1, y1, x2, y2);
        double secondLine = calcLineLength(x3, y3, x4, y4);

        if (firstLine >= secondLine) {
            calcClosestPosition(x1, y1, x2, y2);
        } else {
            calcClosestPosition(x3, y3, x4, y4);
        }

    }

    private static double calcLineLength(long x, long y, long x1, long y1) {
        double firstPoint = Math.pow(x1 - x, 2);
        double secondPoint = Math.pow(y1 - y, 2);
        double result = Math.sqrt(firstPoint + secondPoint);

        return result;
    }

    private static void calcClosestPosition(long x, long y, long x1, long y1) {

        if ( (Math.abs(x) <= Math.abs(x1)) && (Math.abs(y) <= Math.abs(y1))) {
            System.out.printf("(%d, %d)(%d, %d)", x, y, x1, y1);
        } else {
            System.out.printf("(%d, %d)(%d, %d)", x1, y1, x, y);
        }
    }

}
