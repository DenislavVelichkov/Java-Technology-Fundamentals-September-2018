package Exams.MidExam041118;

import java.util.Scanner;

public class DungeonestDark_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split("\\|");

        int initialHealth = 100;
        int initialCoins = 0;

        for (int i = 0; i < line.length; i++) {
            String[] cmd = line[i].split(" ");
            String itemOrMonster = cmd[0];
            int number = Integer.parseInt(cmd[1]);

            switch (itemOrMonster) {
                case "potion":
                    if (initialHealth + number >= 100) {
                        number = 100 - initialHealth;
                        initialHealth = 100;
                    } else {
                        initialHealth += number;
                    }
                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.%n", initialHealth);
                    break;
                case "chest":
                    initialCoins += number;
                    System.out.printf("You found %d coins.%n", number);
                    break;
                default:
                    initialHealth -= number;
                    if (initialHealth > 0) {
                        System.out.printf("You slayed %s.%n", itemOrMonster);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", itemOrMonster);
                        System.out.printf("Best room: %d", i + 1);
                        return;
                    }
                    break;
            }
        }

        System.out.printf("You've made it!%nCoins: %d%nHealth: %d", initialCoins, initialHealth);
    }
}
