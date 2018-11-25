package Arrays_03.Lab;

import java.util.Scanner;

public class DayOfTheWeek_01Ver2 {

    public static void main(String[] args) {

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        Scanner scan = new Scanner(System.in);

        int day = Integer.parseInt(scan.nextLine());

        if (day >= 1 && day <= 7) {
            System.out.println(days[day - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
