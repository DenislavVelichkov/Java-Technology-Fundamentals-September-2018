package ObjectsAndClasses_08.Lab.Dices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int diceCount = Integer.parseInt(sc.nextLine());
        int sidesPerDice = Integer.parseInt(sc.nextLine());
        int winningSum = Integer.parseInt(sc.nextLine());
        List<Dice> dices = new ArrayList<>();

        for (int i = 0; i < diceCount; i++) {
            Dice dice = new Dice(sidesPerDice);
            dices.add(dice);
        }

        int sum = 0;
        for (Dice dice : dices) {
            sum += dice.roll();
        }

        System.out.println("Your sum is: " + sum);
        if (sum >= winningSum) {
            System.out.println("Congratulations, you have won the big nothing.");
        } else {
            System.out.println("Sorry, you have lost, try again.");
        }
    }
}
