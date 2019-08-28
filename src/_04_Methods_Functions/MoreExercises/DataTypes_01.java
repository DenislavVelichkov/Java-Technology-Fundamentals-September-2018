package _04_Methods_Functions.MoreExercises;

import java.util.Scanner;

public class DataTypes_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String inputType = sc.nextLine();
        String data = sc.nextLine();

        if (inputType.equals("int")) {
            int result = Integer.parseInt(data) * 2;
            System.out.println(result);
        } else if (inputType.equals("real")) {
            double result = Double.parseDouble(data) * 1.5;
            System.out.println(String.format("%.2f", result));
        } else if (inputType.equals("string")) {
            System.out.println("$" + data + "$");
        }
    }
}
