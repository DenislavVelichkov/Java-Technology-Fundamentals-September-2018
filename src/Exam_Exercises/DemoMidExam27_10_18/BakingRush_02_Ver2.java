package Exam_Exercises.DemoMidExam27_10_18;

import java.util.Scanner;

public class BakingRush_02_Ver2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] eventDays = sc.nextLine().split("\\|");
        int initialEnergy = 0;
        int initialCoins = 100;

        for (String currentEvent : eventDays) {
            String[] command = currentEvent.split("-");

            String tokens = command[0];
            int points = Integer.parseInt(command[1]);

            switch (tokens) {
                case "rest":

                     if (initialEnergy + points >= 100) {
                        points = 100 - initialEnergy;
                        initialEnergy = 100;

                    } else {
                        initialEnergy += points;
                    }

                    System.out.printf("You gained %d energy.%n", points);
                    System.out.printf("Current energy: %d.%n", initialEnergy);
                    break;
                case "order":

                    if (initialEnergy - 30 >= 0) {
                        initialCoins += points;
                        initialEnergy -= 30;
                        System.out.printf("You earned %d coins.%n", points);

                    } else {
                        initialEnergy += 50;
                        System.out.println("You had to rest!");
                    }

                    break;
                default:
                    initialCoins -= points;

                    if (initialCoins > 0) {
                        System.out.printf("You bought %s.%n", tokens);
                    } else {
                        System.out.printf("Closed! Cannot afford %s.%n", tokens);
                        return;
                    }

                    break;
            }
        }

        System.out.printf("Day completed!%nCoins: %d%nEnergy: %d", initialCoins, initialEnergy);
    }
}
