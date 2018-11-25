package Exams.MidExam041118;

import java.util.Scanner;

public class PartyProfit_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double partySize = Integer.parseInt(sc.nextLine());
        int days = Integer.parseInt(sc.nextLine());
        double coins = 0;

        for (int i = 1; i <= days; i++) {
            if (i % 10 == 0) {
                partySize -= 2;
            }
            if (i % 15 == 0) {
                partySize += 5;
            }
            coins += 50 - partySize * 2;
//            if ((i % 5 == 0) && (i % 3 == 0)) {
//                coins += (partySize * 20) - (partySize * 2);
//            } else
            if (i % 5 == 0) {
                coins += 20 * partySize;
                if (i % 3 == 0) {
                    coins -= partySize * 5;
                }
                continue;
            } else if (i % 3 == 0) {
                coins -= partySize * 3;
            }

        }
        System.out.printf("%.0f companions received %.0f coins each.", partySize, Math.floor(coins / partySize));
    }
}
