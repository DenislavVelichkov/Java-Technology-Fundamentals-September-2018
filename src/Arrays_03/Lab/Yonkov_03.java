package Arrays_03.Lab;

import java.util.Scanner;

public class Yonkov_03 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] moneyCandidate = input.split(" ");
        int moneyLength = moneyCandidate.length;
        double[] money = new double[moneyLength];

        for (int i = 0; i < moneyCandidate.length; i++) {
            String coinCandidate = moneyCandidate[i];
            double coin = Double.parseDouble(coinCandidate);
            money[i] = coin;
        }


    }
}
