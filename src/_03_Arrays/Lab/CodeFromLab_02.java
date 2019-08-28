package Arrays_03.Lab;

import java.util.Scanner;

public class CodeFromLab_02 {

    public static void main(String[] args) {

        //        double[] money =
//                {       10, 24, 12, 12.50, 33.33,
//                        112.51, 102.50, 1250, 1.1, 0.33,
//                        0.44, 1.12
//                };


        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        double[] money = new double[size];

        for (int i = 0; i < money.length; i++) {
            money[i] = Double.parseDouble(sc.nextLine());
        }

        int startPosition = Integer.parseInt(sc.nextLine());
        double sum = money[startPosition];

        String direction = sc.nextLine();

        while (!direction.equals("END")) {
            if (direction.equals("L")) {
                if (startPosition == 0) {
                    System.out.println("Cannot move left. Please move right.");
                } else {
                    startPosition = startPosition - 1;
                    sum += money[startPosition];
                }
            } else if (direction.equals("R")) {
                if (startPosition == money.length - 1) {
                    System.out.println("Cannot move right. Please move left.");
                } else {
                    startPosition = startPosition + 1;
                    sum += money[startPosition];
                }
            } else {
                System.out.println("Invalid direction");
            }
            direction = sc.nextLine();
        }

        System.out.println(sum);
    }
}