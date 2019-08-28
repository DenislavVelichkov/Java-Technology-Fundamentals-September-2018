package _01_Basic_Syntax_Conditional_Statements_And_Loops.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RageExpenses_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
/* •	As output you must print Pesho`s total expenses: "Rage expenses: {expenses} lv."

Every second lost game, Pesho trashes his headset.
Every third lost game, Pesho trashes his mouse.
When Pesho trashes both his mouse and headset in the same lost game, he also trashes his keyboard.
Every second time, when he trashes his keyboard, he also trashes his display.

*/
        int lostGames = Integer.parseInt(reader.readLine());
        float headSetPrice = Float.parseFloat(reader.readLine());
        float mousePrice = Float.parseFloat(reader.readLine());
        float keyboardPrice = Float.parseFloat(reader.readLine());
        float displayPrice = Float.parseFloat(reader.readLine());

        float totalExpenses = 0;
        int keyboardsTrashed = 0;

        for (int i = 1; i <= lostGames; i++) {

            if (i % 2 == 0) {
                totalExpenses += headSetPrice;
            }

            if (i % 3 == 0) {
                totalExpenses += mousePrice;
            }

            if (i % 2 == 0 && i % 3 == 0) {
                keyboardsTrashed++;
                totalExpenses += keyboardPrice;

                if (keyboardsTrashed % 2 == 0) {
                    totalExpenses += displayPrice;
                }
            }
        }
        System.out.printf("Rage expenses: %.2f lv.", totalExpenses);
    }
}
