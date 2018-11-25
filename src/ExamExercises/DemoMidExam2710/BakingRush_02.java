package ExamExercises.DemoMidExam2710;

import java.util.Scanner;

public class BakingRush_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] eventDay = sc.nextLine().split("\\|");


        int initialEnergy = 100;
        int initialCoins = 100;

        int gainedEnergy = initialEnergy;
        int coinsEarned = initialCoins;

        for (String command : eventDay) {

            String[] day = command.split("-");

            String action = day[0];
            int points = Integer.parseInt(day[1]);

            switch (action) {
                case "rest":
                    gainedEnergy += points;

                    if (gainedEnergy > initialEnergy) {
                        System.out.println("You gained 0 energy.");
                        gainedEnergy = initialEnergy;
                    } else {
                        System.out.printf("You gained %d energy.%n", points);
                    }

                    System.out.printf("Current energy: %d.%n", gainedEnergy);

                    break;
                case "order":
                    gainedEnergy -= 30;

                    if (gainedEnergy > 0) {
                        System.out.printf("You earned %d coins.%n", points);
                        coinsEarned += points;
                    } else {
                        gainedEnergy += 50;
                        System.out.println("You had to rest!");
                        continue;
                    }

                    break;
                default:
                    coinsEarned -= points;

                    if (coinsEarned <= 0) {
                        System.out.printf("Closed! Cannot afford %s.%n", action);
                        return;
                    } else {
                        System.out.printf("You bought %s.%n", action);
                    }

                    break;
            }
        }
        System.out.printf("Day completed!%nCoins: %d%nEnergy: %d", coinsEarned, gainedEnergy);
    }
}
