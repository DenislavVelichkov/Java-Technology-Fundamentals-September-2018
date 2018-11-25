package BasicSyntaxConditionalStatementsAndLoops_01.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheatrePromotion_07_Lab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String typeOfday = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        if (age >= 0 && age <= 18) {
            switch (typeOfday) {
                case "Weekday":
                    System.out.println("12$");
                    break;
                case "Weekend":
                    System.out.println("15$");
                    break;
                case "Holiday":
                    System.out.println("5$");
                    break;
            }
        } else if (age > 18 && age <= 64) {
            switch (typeOfday) {
                case "Weekday":
                    System.out.println("18$");
                    break;
                case "Weekend":
                    System.out.println("20$");
                    break;
                case "Holiday":
                    System.out.println("12$");
                    break;
            }
        } else if (age > 64 && age <= 122) {
            switch (typeOfday) {
                case "Weekday":
                    System.out.println("12$");
                    break;
                case "Weekend":
                    System.out.println("15$");
                    break;
                case "Holiday":
                    System.out.println("10$");
                    break;
            }
        } else {
            System.out.println("Error!");
        }
    }
}
