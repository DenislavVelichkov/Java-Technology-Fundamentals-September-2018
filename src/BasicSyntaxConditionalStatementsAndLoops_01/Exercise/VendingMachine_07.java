package BasicSyntaxConditionalStatementsAndLoops_01.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VendingMachine_07 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double nuts = 2.0, water = 0.7, crisps = 1.5, soda = 0.8, coke = 1.0;
        double totMoneyInserted = 0;

        while (true) {
            try {
                double moneyIns = Double.parseDouble(reader.readLine()); //Ends loop if string is not number

                if (moneyIns == 0.1 || moneyIns == 0.2 || moneyIns == 0.5
                        || moneyIns == 1 || moneyIns == 2)
                    totMoneyInserted += moneyIns;
                else
                    System.out.printf("Cannot accept %.2f%n", moneyIns);


            } catch (NumberFormatException e) {
                break;
            }
        }

        while (true) {
            String productToBuy = reader.readLine();
            if (productToBuy.equals("Nuts") || productToBuy.equals("Water") || productToBuy.equals("Crisps") ||
                    productToBuy.equals("Soda") || productToBuy.equals("Coke")) {

                switch (productToBuy) {
                    case "Nuts":
                        if (totMoneyInserted >= nuts) {
                            System.out.println("Purchased Nuts");
                            totMoneyInserted -= nuts;
                        } else
                            System.out.println("Sorry, not enough money");
                        break;

                    case "Water":
                        if (totMoneyInserted >= water) {
                            System.out.println("Purchased Water");
                            totMoneyInserted -= water;
                        } else
                            System.out.println("Sorry, not enough money");
                        break;

                    case "Crisps":
                        if (totMoneyInserted >= crisps) {
                            System.out.println("Purchased Crisps");
                            totMoneyInserted -= crisps;
                        } else
                            System.out.println("Sorry, not enough money");
                        break;

                    case "Soda":
                        if (totMoneyInserted >= soda) {
                            System.out.println("Purchased Soda");
                            totMoneyInserted -= soda;
                        } else
                            System.out.println("Sorry, not enough money");
                        break;

                    case "Coke":
                        if (totMoneyInserted >= coke) {
                            System.out.println("Purchased Coke");
                            totMoneyInserted -= coke;
                        } else
                            System.out.println("Sorry, not enough money");
                        break;

                }
            } else if (productToBuy.equals("End")) break;

            else
                System.out.println("Invalid product");

        }
        System.out.printf("Change: %.2f", totMoneyInserted);
    }
}