package Exam_Exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UpgradedMatcher_08 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] products = sc.nextLine().split(" ");
        long[] quantities = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        double[] prices = Arrays.stream(sc.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        Map<String, Long> quantitiesByProduct = new HashMap<>();
        Map<String, Double> pricesByProduct = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            String product = products[i];
            if (i >= quantities.length) {
                quantitiesByProduct.put(product, 0L);
            } else {
                quantitiesByProduct.put(product, quantities[i]);
            }
            pricesByProduct.put(product, prices[i]);
        }

        String productAndPrice = sc.nextLine();
        while (!productAndPrice.equals("done")) {
            String[] productPair = productAndPrice.split(" ");
            String product = productPair[0];
            long quantity = Long.parseLong(productPair[1]);
            long oldQuantity = quantitiesByProduct.get(product);
            if (oldQuantity < quantity) {
                System.out.printf("We do not have enough %s%n", product);
            } else {
                System.out.printf("%s x %d costs %.2f%n", product, quantity, pricesByProduct.get(product) * quantity);
                quantitiesByProduct.put(product, oldQuantity - quantity);
            }

            productAndPrice = sc.nextLine();
        }
    }
}